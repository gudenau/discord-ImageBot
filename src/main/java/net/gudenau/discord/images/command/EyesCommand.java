package net.gudenau.discord.images.command;

import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.api.command.IImageCommand;
import net.gudenau.discord.images.api.command.Result;
import net.gudenau.discord.images.magick.ExceptionInfo;
import net.gudenau.discord.images.magick.Image;
import net.gudenau.discord.images.magick.PixelCache;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import static org.opencv.core.CvType.CV_8UC4;
import static org.opencv.imgcodecs.Imgcodecs.imwrite;
import static org.opencv.objdetect.Objdetect.CASCADE_SCALE_IMAGE;

public class EyesCommand implements IImageCommand{
    private static final CascadeClassifier faceCascade;
    private static final CascadeClassifier eyesCascade;
    
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        
        faceCascade = new CascadeClassifier();
        eyesCascade = new CascadeClassifier();
        
        if(!faceCascade.load("./resources/cascade/face.xml")){
            throw new RuntimeException("Failed to load ./resources/cascade/face.xml");
        }
        if(!eyesCascade.load("resources/cascade/eyes.xml")){
            throw new RuntimeException("Failed to load ./resources/cascade/eyes.xml");
        }
    }
    
    @Nonnull
    @Override
    public Result process(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments, @Nonnull Image image){
        Mat imageCv;
        try(var exception = new ExceptionInfo()){
            var pixels = PixelCache.AcquireImagePixels(
                image,
                0, 0,
                image.columns(), image.rows(),
                exception
            );
            
            var ji = new java.awt.image.BufferedImage(image.columns(), image.rows(), java.awt.image.BufferedImage.TYPE_4BYTE_ABGR);
            int[] row = new int[image.columns()];
            int[] doubleRow = new int[image.columns() * 2];
            var intPixels = pixels.asIntBuffer();
            for(int y = 0; y < image.rows(); y++){
                intPixels.get(doubleRow);
                for(int i = 0; i < row.length; i++){
                    row[i] = Integer.reverseBytes(doubleRow[i * 2]);
                }
                ji.setRGB(0, y, image.columns(), 1, row, 0, image.columns());
            }
            try{
                javax.imageio.ImageIO.write(ji, "PNG", new java.io.File("./javaInput.png"));
            }catch(Throwable t){
                t.printStackTrace();
            }
            
            imageCv = new Mat(
                image.rows(), image.columns(),
                CV_8UC4,
                pixels
            );
        }
        
        imwrite("./input.png", imageCv);
        
        var grayImage = new Mat();
        Imgproc.cvtColor(imageCv, grayImage, Imgproc.COLOR_BGRA2GRAY);
        imwrite("./grayscale.png", grayImage);
        Imgproc.equalizeHist(grayImage, grayImage);
        imwrite("./equalized.png", grayImage);
    
        var faces = new MatOfRect();
        faceCascade.detectMultiScale(grayImage, faces, 1.1, 2, CASCADE_SCALE_IMAGE);
        
        var stringBuilder = new StringBuilder("Detected faces:\n");
        for(var face : faces.toArray()){
            stringBuilder
                .append("X: ").append(face.x + (face.width >> 1)).append("\n")
                .append("Y: ").append(face.x + (face.width >> 1)).append("\n");
        }
        
        return Result.success(stringBuilder.toString());
    }
    
    @Nonnull
    @Override
    public String getName(){
        return "eyes";
    }
    
    @Nonnull
    @Override
    public String getHelp(){
        return "Puts funny eyes on a face.";
    }
    
    @Nonnull
    @Override
    public String getUsage(){
        return "eyes [image] [eye]";
    }
}

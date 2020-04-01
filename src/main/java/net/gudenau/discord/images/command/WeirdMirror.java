package net.gudenau.discord.images.command;

import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.api.command.IImageCommand;
import net.gudenau.discord.images.api.command.Result;
import net.gudenau.discord.images.magick.Composite;
import net.gudenau.discord.images.magick.ExceptionInfo;
import net.gudenau.discord.images.magick.Image;
import net.gudenau.discord.images.magick.RectangleInfo;
import net.gudenau.discord.images.magick.Transform;

public class WeirdMirror{
    public static class Woow implements IImageCommand{
        @Nonnull
        @Override
        public Result process(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments, @Nonnull Image image){
            try(var exception = new ExceptionInfo()){
                var flip = exception.check(Transform.FlipImage(image, exception));
                
                try{
                    Image crop;
                    int cropHeight = flip.rows() >> 1;
                    try(var cropGeometry = new RectangleInfo()){
                        cropGeometry.x(0);
                        cropGeometry.y(cropHeight);
                        cropGeometry.width(flip.columns());
                        cropGeometry.height(cropHeight);
                        
                        crop = exception.check(Transform.CropImage(
                            flip,
                            cropGeometry,
                            exception
                        ));
                    }
                    try{
                        Composite.CompositeImage(
                            image,
                            Image.CopyCompositeOp,
                            crop,
                            0, cropHeight
                        );
                        
                        return Result.image(Image.ReferenceImage(image));
                    }finally{
                        Image.DestroyImage(crop);
                    }
                }finally{
                    Image.DestroyImage(flip);
                }
            }
        }
    
        @Nonnull
        @Override
        public String getName(){
            return "woow";
        }
    
        @Nonnull
        @Override
        public String getHelp(){
            return "Mirrors the top half of an image onto the bottom half.";
        }
    
        @Nonnull
        @Override
        public String getUsage(){
            return "woow [image]";
        }
    }
    
    public static class Hooh implements IImageCommand{
        @Nonnull
        @Override
        public Result process(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments, @Nonnull Image image){
            try(var exception = new ExceptionInfo()){
                var flip = exception.check(Transform.FlipImage(image, exception));
                
                try{
                    Image crop;
                    int cropHeight = flip.rows() >> 1;
                    try(var cropGeometry = new RectangleInfo()){
                        cropGeometry.x(0);
                        cropGeometry.y(0);
                        cropGeometry.width(flip.columns());
                        cropGeometry.height(cropHeight);
                        
                        crop = exception.check(Transform.CropImage(
                            flip,
                            cropGeometry,
                            exception
                        ));
                    }
                    try{
                        Composite.CompositeImage(
                            image,
                            Image.CopyCompositeOp,
                            crop,
                            0, 0
                        );
                        
                        return Result.image(Image.ReferenceImage(image));
                    }finally{
                        Image.DestroyImage(crop);
                    }
                }finally{
                    Image.DestroyImage(flip);
                }
            }
        }
        
        @Nonnull
        @Override
        public String getName(){
            return "hooh";
        }
        
        @Nonnull
        @Override
        public String getHelp(){
            return "Mirrors the bottom half of an image onto the top half.";
        }
        
        @Nonnull
        @Override
        public String getUsage(){
            return "hooh [image]";
        }
    }
    
    public static class Waaw implements IImageCommand{
        @Nonnull
        @Override
        public Result process(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments, @Nonnull Image image){
            try(var exception = new ExceptionInfo()){
                var flop = exception.check(Transform.FlopImage(image, exception));
                
                try{
                    Image crop;
                    int cropWidth = flop.columns() >> 1;
                    try(var cropGeometry = new RectangleInfo()){
                        cropGeometry.x(0);
                        cropGeometry.y(0);
                        cropGeometry.width(cropWidth);
                        cropGeometry.height(flop.rows());
                        
                        crop = exception.check(Transform.CropImage(
                            flop,
                            cropGeometry,
                            exception
                        ));
                    }
                    try{
                        Composite.CompositeImage(
                            image,
                            Image.CopyCompositeOp,
                            crop,
                            0, 0
                        );
                        
                        return Result.image(Image.ReferenceImage(image));
                    }finally{
                        Image.DestroyImage(crop);
                    }
                }finally{
                    Image.DestroyImage(flop);
                }
            }
        }
        
        @Nonnull
        @Override
        public String getName(){
            return "waaw";
        }
        
        @Nonnull
        @Override
        public String getHelp(){
            return "Mirrors the right half of an image onto the left half.";
        }
        
        @Nonnull
        @Override
        public String getUsage(){
            return "waaw [image]";
        }
    }
    
    public static class Haah implements IImageCommand{
        @Nonnull
        @Override
        public Result process(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments, @Nonnull Image image){
            try(var exception = new ExceptionInfo()){
                var flop = exception.check(Transform.FlopImage(image, exception));
                
                try{
                    Image crop;
                    int cropWidth = flop.columns() >> 1;
                    try(var cropGeometry = new RectangleInfo()){
                        cropGeometry.x(cropWidth);
                        cropGeometry.y(0);
                        cropGeometry.width(cropWidth);
                        cropGeometry.height(flop.rows());
                        
                        crop = exception.check(Transform.CropImage(
                            flop,
                            cropGeometry,
                            exception
                        ));
                    }
                    try{
                        Composite.CompositeImage(
                            image,
                            Image.CopyCompositeOp,
                            crop,
                            cropWidth, 0
                        );
                        
                        return Result.image(Image.ReferenceImage(image));
                    }finally{
                        Image.DestroyImage(crop);
                    }
                }finally{
                    Image.DestroyImage(flop);
                }
            }
        }
        
        @Nonnull
        @Override
        public String getName(){
            return "haah";
        }
        
        @Nonnull
        @Override
        public String getHelp(){
            return "Mirrors the left half of an image onto the right half.";
        }
        
        @Nonnull
        @Override
        public String getUsage(){
            return "haah [image]";
        }
    }
}

package net.gudenau.discord.images.api.command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.requests.RestAction;
import net.gudenau.discord.images.magick.ExceptionInfo;
import net.gudenau.discord.images.magick.Image;
import net.gudenau.discord.images.magick.ImageList;
import net.gudenau.discord.images.magick.Resize;
import net.gudenau.discord.images.util.ImageUtil;

/**
 * A class that holds the result of a command.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public abstract class Result{
    /**
     * Prepares the result to a be posted to a channel.
     *
     * @param channel The channel to post in.
     * @param author The member that issued the command.
     *
     * @return The prepared post.
     *
     * @since 1.0.0
     * */
    public abstract RestAction<Message> preparePost(@Nonnull TextChannel channel, @Nonnull Member author);
    
    /**
     * Used to clean up any resources that might be in use.
     *
     * @since 1.0.0
     * */
    public void cleanup(){}
    
    /**
     * A result with an image and a message.
     *
     * @param image The image to upload.
     * @param format The format of the message.
     * @param args The arguments to be formatted.
     *
     * @return The result.
     *
     * @since 1.0.0
     * */
    @Nonnull
    public static Result image(@Nonnull Image image, @Nonnull String format, Object... args){
        return image(image, String.format(format, args));
    }
    
    /**
     * A result with an image.
     *
     * @param image The image to upload.
     *
     * @return The result.
     *
     * @since 1.0.0
     * */
    @Nonnull
    public static Result image(@Nonnull Image image){
        return image(image, null);
    }
    
    /**
     * A result with an image and a message.
     *
     * @param image The image to upload.
     * @param message The message.
     *
     * @return The result.
     *
     * @since 1.0.0
     * */
    @Nonnull
    public static Result image(@Nonnull Image image, @Nullable String message){
        return new ImageResult(image, message);
    }
    
    /**
     * A result with an image and a message.
     *
     * @param url The URL of the image.
     * @param format The format of the message.
     * @param args The arguments to be formatted.
     *
     * @return The result.
     *
     * @since 1.0.0
     * */
    @Nonnull
    public static Result image(@Nonnull String url, @Nonnull String format, Object... args){
        return image(url, String.format(format, args));
    }
    
    /**
     * A result with an image.
     *
     * @param url The URL of the image.
     *
     * @return The result.
     *
     * @since 1.0.0
     * */
    @Nonnull
    public static Result image(@Nonnull String url){
        return image(url, null);
    }
    
    /**
     * A result with an image and a message.
     *
     * @param url The URL of the image.
     * @param message The message.
     *
     * @return The result.
     *
     * @since 1.0.0
     * */
    @Nonnull
    public static Result image(@Nonnull String url, @Nullable String message){
        return new ImageResultUrl(url, message);
    }
    
    /**
     * A result with an image and a message.
     *
     * @param path The Path to the image.
     * @param format The format of the message.
     * @param args The arguments to be formatted.
     *
     * @return The result.
     *
     * @since 1.0.0
     * */
    @Nonnull
    public static Result image(@Nonnull Path path, @Nonnull String format, Object... args){
        return image(path, String.format(format, args));
    }
    
    /**
     * A result with an image.
     *
     * @param path The Path to the image.
     *
     * @return The result.
     *
     * @since 1.0.0
     * */
    @Nonnull
    public static Result image(@Nonnull Path path){
        return image(path, null);
    }
    
    /**
     * A result with an image and a message.
     *
     * @param path The Path to the image.
     * @param message The message.
     *
     * @return The result.
     *
     * @since 1.0.0
     * */
    @Nonnull
    public static Result image(@Nonnull Path path, @Nullable String message){
        return new ImageResultLocal(path, message);
    }
    
    /**
     * A result with help message for the command.
     *
     * @param command The command to get help for
     *
     * @return The result.
     *
     * @since 1.0.0
     * */
    @Nonnull
    public static Result help(@Nonnull IMessageCommand command){
        return error("%s\n\nUsage: %s", command.getHelp(), command.getUsage());
    }
    
    /**
     * A result with an error message.
     *
     * @param message The error message.
     *
     * @return The result.
     *
     * @since 1.0.0
     * */
    @Nonnull
    public static Result error(@Nonnull String message){
        return text(Status.FAIL, message);
    }
    
    /**
     * A result with an error message.
     *
     * @param format The format of the error message.
     * @param args The arguments to be formatted.
     *
     * @return The result.
     *
     * @since 1.0.0
     * */
    @Nonnull
    public static Result error(@Nonnull String format, Object... args){
        return error(String.format(format, args));
    }
    
    
    /**
     * A result with a success message.
     *
     * @param message The success message.
     *
     * @return The result.
     *
     * @since 1.0.0
     * */
    @Nonnull
    public static Result success(@Nonnull String message){
        return text(Status.SUCCESS, message);
    }
    
    /**
     * A result with a success message.
     *
     * @param format The format of the success message.
     * @param args The arguments to be formatted.
     *
     * @return The result.
     *
     * @since 1.0.0
     * */
    @Nonnull
    public static Result success(@Nonnull String format, Object... args){
        return success(String.format(format, args));
    }
    
    /**
     * A result with a message.
     *
     * @param format The format of the message.
     * @param args The arguments to be formatted.
     *
     * @return The result.
     *
     * @since 1.0.0
     * */
    @Nonnull
    public static Result text(@Nonnull Status status, @Nonnull String format, Object... args){
        return text(status, String.format(format, args));
    }
    
    /**
     * A result with a message.
     *
     * @param message The message.
     *
     * @return The result.
     *
     * @since 1.0.0
     * */
    @Nonnull
    public static Result text(@Nonnull Status status, @Nonnull String message){
        return new TextResult(message, status);
    }
    
    /**
     * A result with text and a color.
     *
     * @author gudenau
     * @since 1.0.0
     * */
    private static class TextResult extends Result{
        /**
         * The message of this result.
         *
         * @since 1.0.0
         * */
        private final String message;
        /**
         * The color of the embed.
         *
         * @since 1.0.0
         * */
        private final int color;
    
        private TextResult(String message, Status status){
            this(message, status.getColor());
        }
        
        private TextResult(String message, int color){
            this.message = message;
            this.color = color;
        }
    
        @Override
        public RestAction<Message> preparePost(@Nonnull TextChannel channel, @Nonnull Member author){
            var embed = new EmbedBuilder()
                .setAuthor(author.getEffectiveName(), null, author.getUser().getEffectiveAvatarUrl())
                .setDescription(message)
                .setColor(color)
                .build();
            
            return channel.sendMessage(
                new MessageBuilder()
                    .setEmbed(embed)
                    .build()
            );
        }
    }
    
    /**
     * A result with an image to upload.
     *
     * @author gudenau
     * @since 1.0.0
     * */
    private static class ImageResult extends Result implements IPipeResult{
        /**
         * The image to upload.
         *
         * @since 1.0.0
         * */
        private final Image image;
        /**
         * The message to accommodate the image.
         *
         * @since 1.0.0
         * */
        private final String message;
    
        public ImageResult(Image image, String message){
            this.image = Image.ReferenceImage(image);
            this.message = message;
        }
    
        @Override
        public RestAction<Message> preparePost(@Nonnull TextChannel channel, @Nonnull Member author){
            float scale = 1;
            
            var fileType = ImageList.GetImageListLength(image) == 1 ? "png" : "gif";
            image.magick(fileType);
            
            while(true){
                
                byte[] imageData;
                if(scale == 1){
                    imageData = ImageUtil.writeImage(image);
                }else{
                    try(var exception = new ExceptionInfo()){
                        var scaledImage = Resize.ThumbnailImage(
                            image,
                            Math.round(image.columns() * scale),
                            Math.round(image.rows() * scale),
                            exception
                        );
                        try{
                            imageData = ImageUtil.writeImage(scaledImage);
                        }finally{
                            Image.DestroyImage(scaledImage);
                        }
                    }
                }

                if(imageData.length > 8000000){
                    scale *= 0.75;
                    continue;
                }
                
                var fileName = "result." + fileType;
            
                return channel.sendFile(imageData, fileName)
                    .embed(new EmbedBuilder()
                        .setAuthor(author.getEffectiveName(), null, author.getUser().getEffectiveAvatarUrl())
                        .setDescription(message)
                        .setColor(Status.SUCCESS.getColor())
                        .setImage("attachment://" + fileName)
                        .build()
                    );
            }
        }
    
        @Override
        public void cleanup(){
            Image nextImage = image;
            while(nextImage != null){
                Image image = nextImage;
                nextImage = ImageList.GetNextImageInList(image);
                Image.DestroyImage(image);
            }
        }
    
        @Override
        @Nonnull
        public Image getImage(){
            return image;
        }
    }
    
    /**
     * A result with an image URL.
     *
     * @author gudenau
     * @since 1.0.0
     * */
    private static class ImageResultUrl extends Result implements IPipeResult{
        /**
         * The url of the image to post.
         *
         * @since 1.0.0
         * */
        private final String url;
        /**
         * The message to accommodate the image.
         *
         * @since 1.0.0
         * */
        private final String message;
        /**
         * The image, if it was downloaded.
         *
         * @since 1.0.0
         * */
        private volatile Image image;
    
        public ImageResultUrl(String url, String message){
            this.url = url;
            this.message = message;
        }
    
        @Override
        public RestAction<Message> preparePost(@Nonnull TextChannel channel, @Nonnull Member author){
            var embed = new EmbedBuilder()
                .setAuthor(author.getEffectiveName(), null, author.getUser().getEffectiveAvatarUrl())
                .setImage(url)
                .setDescription(message)
                .setColor(Status.SUCCESS.getColor())
                .build();
    
            return channel.sendMessage(
                new MessageBuilder()
                    .setEmbed(embed)
                    .build()
            );
        }
    
        @Override
        @Nullable
        public Image getImage(){
            synchronized(this){
                if(image == null){
                    image = ImageUtil.downloadImage(url);
                }
                return image;
            }
        }
    
        @Override
        public void cleanup(){
            if(image != null){
                Image nextImage = image;
                while(nextImage != null){
                    Image image = nextImage;
                    nextImage = ImageList.GetNextImageInList(image);
                    Image.DestroyImage(image);
                }
            }
        }
    }
    
    /**
     * A result with an image Path.
     *
     * @author gudenau
     * @since 1.0.0
     * */
    private static class ImageResultLocal extends Result implements IPipeResult{
        private final Path path;
        private final String message;
        private volatile Image image;
    
        public ImageResultLocal(Path path, String message){
            this.path = path;
            this.message = message;
        }
    
        @Override
        public RestAction<Message> preparePost(@Nonnull TextChannel channel, @Nonnull Member author){
            var name = path.getFileName().toString();
            var extension = name.substring(name.lastIndexOf('.'));
            name = "result" + extension;
            try{
                return channel.sendFile(Files.newInputStream(path), name)
                    .embed(new EmbedBuilder()
                        .setAuthor(author.getEffectiveName(), null, author.getUser().getEffectiveAvatarUrl())
                        .setDescription(message)
                        .setColor(Status.SUCCESS.getColor())
                        .setImage("attachment://" + name)
                        .build()
                    );
            }catch(IOException e){
                e.printStackTrace();
                return error("Failed to upload image").preparePost(channel, author);
            }
        }
    
        @Nullable
        @Override
        public Image getImage(){
            synchronized(this){
                if(image == null){
                    image = ImageUtil.loadImage(path);
                }
                return image;
            }
        }
    
        @Override
        public void cleanup(){
            if(image != null){
                Image.DestroyImage(image);
            }
        }
    }
    
    /**
     * An interface for a result that contains an image.
     *
     * Used for piping.
     *
     * @author gudenau
     * @since 1.0.0
     * */
    public interface IPipeResult{
        /**
         * Get the {@link Image Image} from this result.
         *
         * @return The image
         *
         * @since 1.0.0
         * */
        @Nullable
        Image getImage();
    }
    
    /**
     * The status of a result.
     *
     * @author gudenau
     * @since 1.0.0
     * */
    public enum Status{
        /**
         * The result is positive.
         *
         * @since 1.0.0
         * */
        SUCCESS(0x00AA00),
        /**
         * The result is negitave.
         *
         * @since 1.0.0
         * */
        FAIL(0xAA0000);
    
        /**
         * The color of the result for embeds.
         *
         * @since 1.0.0
         * */
        private final int color;
    
        Status(int color){
            this.color = color;
        }
        
        /**
         * Gets the color of this result.
         *
         * @return The color.
         * */
        public int getColor(){
            return color;
        }
    }
}

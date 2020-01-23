package com.teedel.MinecraftButWithGoogleImages.model;

import javafx.scene.control.TextArea;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
 * @author mkyong
 * modified by TeeDeL (Josh Swift)
 */
public class ImageResizeTool {

    private int IMG_DIMENSIONS;
    private boolean done;

    public ImageResizeTool(int dimensions)
    {
        IMG_DIMENSIONS = dimensions;
        done = false;
    }

    public void resize(String name)
    {
        try {

            BufferedImage originalImage = ImageIO.read(new File("C:\\newname\\assets\\minecraft\\textures\\block\\" + name + ".png"));
            //TODO This can fail
            //int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

            BufferedImage resizeImage = resizeImage(originalImage);
            ImageIO.write(resizeImage, "png", new File("C:\\newname\\assets\\minecraft\\textures\\block\\" + name + ".png"));
            done = true;

        } catch (IOException e) {
            System.err.println("Failed to resize " + name);
            e.printStackTrace();
        }
    }


    private BufferedImage resizeImage(BufferedImage originalImage){
        BufferedImage resizedImage = new BufferedImage(IMG_DIMENSIONS, IMG_DIMENSIONS, 2);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_DIMENSIONS, IMG_DIMENSIONS, null);
        g.dispose();

        return resizedImage;
    }

    public boolean isDone()
    {
        return done;
    }
}

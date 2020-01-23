package com.teedel.MinecraftButWithGoogleImages.tester;

import java.io.File;

public class TestFeatures
{

    public static void main(String[] args)
    {
        showFiles(new File("newname/assets/minecraft/textures/block"));
    }

    private static void showFiles(File node)
    {
        if (!node.getName().contains(".mcmeta"))
        {
            System.out.println(nameFormatter(node.getName()));
        }

        if (node.isDirectory())
        {
            String[] subNote = node.list();
            for(String fileName : subNote)
            {
                showFiles(new File(node, fileName));
            }
        }
    }

    private static String nameFormatter(String originalText)
    {
        String formattedText = originalText.replace(".png", "");
        formattedText = formattedText.replace("_", " ");
        return formattedText;
    }

}

package com.teedel.MinecraftButWithGoogleImages.model;

public class FormatFix {

    private String newString;

    public FormatFix()
    {
        newString = "";
    }

    public String addUnderscore(String originalText)
    {
        if (originalText.contains(" "))
        {
            newString = originalText.replace(" ", "_");
        } else {
            newString = originalText;
        }
        return newString;
    }

    private static String nameFormatter(String originalText)
    {
        String formattedText = originalText.replace(".png", "");
        formattedText = formattedText.replace("_", " ");
        return formattedText;
    }

}

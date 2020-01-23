package com.teedel.MinecraftButWithGoogleImages.Launch;

import java.io.File;
import java.util.ArrayList;

public class NameMapper
{
    public static void main(String[] args) {
        new NameMapper();
        for (String block : nameList)
        {
            System.out.println(block);
        }
    }

    private static ArrayList<String> nameList;
    private File blockPath;

    public NameMapper()
    {
        nameList = new ArrayList<>();
        blockPath = new File("C:\\newname\\assets\\minecraft\\textures\\block");
        addNamesToList(blockPath,nameList);
    }

    private static void addNamesToList(File node, ArrayList<String> list)
    {
        String itemName = node.getName();

        if (!itemName.contains(".mcmeta"))
        {
            if (!itemName.contentEquals("block")) {
                list.add(nameFormatter(node.getName()));
            }
        }

        if (node.isDirectory())
        {
            String[] subNote = node.list();
            for(String fileName : subNote)
            {
                addNamesToList(new File(node, fileName), list);
            }
        }
    }

    private static String nameFormatter(String originalText)
    {
        String formattedText = originalText.replace(".png", "");
        formattedText = formattedText.replace("_", " ");
        return formattedText;
    }

    public ArrayList<String> getNameList()
    {
        return nameList;
    }
}

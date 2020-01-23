package com.teedel.MinecraftButWithGoogleImages.model;


import java.io.File;


public class DirectoryCreator
{

    public boolean createPackDir(String texturePackName)
    {
        String packName = texturePackName + "/assets/minecraft/textures/block";
        File file = new File(packName);
        return file.mkdirs();
    }

}

package com.teedel.MinecraftButWithGoogleImages.tester;

import java.io.File;

public class PathTest {
    public static void main(String[] args) {
        File blockPath = new File("C:\\newname\\assets\\minecraft\\textures\\block");
        File blockPath2 = new File("C:/newname/assets/minecraft/textures/block");
        System.out.println(blockPath.isDirectory());
        System.out.println(blockPath2.isDirectory());
    }
}

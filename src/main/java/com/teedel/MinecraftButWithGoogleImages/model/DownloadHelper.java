package com.teedel.MinecraftButWithGoogleImages.model;

import javafx.scene.control.TextArea;
import lombok.extern.slf4j.Slf4j;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;
import java.util.Random;

@Slf4j
public class DownloadHelper {

    private static String IMAGE_DESTINATION_FOLDER;
    private int failedDownloadCount;
    private List<String> resultUrls;
    private String chosenUrl;

    public DownloadHelper(List<String> resultUrls, String path)
    {
        this.resultUrls = resultUrls;
        chosenUrl = "";
        IMAGE_DESTINATION_FOLDER = path;
        failedDownloadCount = 0;
    }

    public void downloadImage(String outName, int randomness)
    {
        FormatFix ff = new FormatFix();
        //TODO This can produce -1
        int chosenNum = (rng(0, resultUrls.size()) - 1)/randomness;
        //System.out.println("RanNum:" + chosenNum  + " UrlList.Size:" + resultUrls.size() + "\tImageName:" + outName);
        if (chosenNum == 0 && resultUrls.size() == 0)
        {
            for (String link : resultUrls)
            {
                //System.out.println(link);
            }
        }
        else
        {
            chosenUrl = resultUrls.get(chosenNum);
        }
        log.info("Downloading: " + outName);
        //get file name from image path
        String strImageName = chosenUrl.substring(chosenUrl.lastIndexOf("/") + 1);

        log.info("Saving: " + strImageName + ", from: " + chosenUrl);

        try {

            //open the stream from URL
            URL urlImage = new URL(chosenUrl);
            InputStream in = urlImage.openStream();

            byte[] buffer = new byte[4096];
            int n = -1;

            OutputStream os = new FileOutputStream(IMAGE_DESTINATION_FOLDER + "/" + ff.addUnderscore(outName) + ".png");
            //write bytes to the output stream
            while ((n = in.read(buffer)) != -1) {
                os.write(buffer, 0, n);
            }

            //close the stream
            os.close();

        } catch (IOException e) {
            failedDownloadCount += 1;
            if (failedDownloadCount >= 10) {
                //log.appendText("Failed to download " + outName + " 10 times, skipping\n");
            } else {
                //log.appendText("Error downloading " + outName + ", trying another\n");
                downloadImage(outName, randomness);
            }
        }
    }

    private static int rng(int min, int max) {
        if (min > max) {
            System.err.println("min=" + min + "\tmax=" + max);
            throw new IllegalArgumentException("Max must be bigger than min");

        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}

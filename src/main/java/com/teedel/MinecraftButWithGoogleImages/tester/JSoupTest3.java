package com.teedel.MinecraftButWithGoogleImages.tester;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JSoupTest3 {

    private static String IMAGE_DESTINATION_FOLDER = "C:/images";
    private static List<String> resultUrls = new ArrayList<String>();

    public static void main(String[] args) {
/*
        String searchTerm = "stone";

        String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36";
        String url = "https://www.google.com/search?q=" + searchTerm + "&tbm=isch";

        try {
            Document doc = Jsoup.connect(url).userAgent(userAgent).referrer("https://www.google.com/").get();

            Elements elements = doc.select("div.rg_meta");

            JSONObject jsonObject;
            for (Element element : elements) {
                if (element.childNodeSize() > 0) {
                    jsonObject = (JSONObject) new JSONParser().parse(element.childNode(0).toString());

                    String urlString = (String) jsonObject.get("ou");
                    if (urlString.endsWith(".png") || urlString.endsWith(".jpg"))
                    {
                        resultUrls.add(urlString);
                    }
                }
            }
            int num = rng(0,resultUrls.size());
            downloadImage(resultUrls.get(num), searchTerm);
        } catch (IOException | ParseException e)
        {
            e.printStackTrace();
        }
        */
    }

    private static int rng(int min, int max) {
        if ( min >= max) {
            throw new IllegalArgumentException("Max must be bigger than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }



    private static void downloadImage(String strImageURL, String outName){

        //get file name from image path
        String strImageName =
                strImageURL.substring( strImageURL.lastIndexOf("/") + 1 );

        System.out.println("Saving: " + strImageName + ", from: " + strImageURL);

        try {

            //open the stream from URL
            URL urlImage = new URL(strImageURL);
            InputStream in = urlImage.openStream();

            byte[] buffer = new byte[4096];
            int n = -1;

            OutputStream os =
                    new FileOutputStream( IMAGE_DESTINATION_FOLDER + "/" + outName + ".png" );

            //write bytes to the output stream
            while ( (n = in.read(buffer)) != -1 ){
                os.write(buffer, 0, n);
            }

            //close the stream
            os.close();

            System.out.println("Image saved");

        } catch (IOException e) {
            System.err.println("Error downloading image, trying another");
            downloadImage(resultUrls.get(rng(0,resultUrls.size())), outName);
        }

    }
}

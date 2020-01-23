package com.teedel.MinecraftButWithGoogleImages.tester;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class JSoupScratch
{


    public static void main(String[] args) {

        String searchTerm = "stone";

        try {
            Document doc = Jsoup.connect("https://www.bing.com/images/search?q=" + searchTerm).userAgent("Mozilla/5.0 (X11; Linux i686) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.114 Safari/537.36").get();

            //System.out.println(doc.select("#rg div.rg_di img"));
            Elements imageElements = doc.getElementsByClass("mimg");

            for (Element e : imageElements)
            {
                String src = e.text("https://").toString();
                //String strImageURL = e.getElementsByAttribute("abs:src").toString();
                //System.out.println(e.getElementsByAttributeStarting("src"));
                System.out.println(src);
                //downloadImage(src);
            }
            //Element element = html.sel
        } catch (Exception e){

        }
    }
    private static String IMAGE_DESTINATION_FOLDER = "C:/images";

    private static void downloadImage(String strImageURL){

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
                    new FileOutputStream( IMAGE_DESTINATION_FOLDER + "/" + strImageName );

            //write bytes to the output stream
            while ( (n = in.read(buffer)) != -1 ){
                os.write(buffer, 0, n);
            }

            //close the stream
            os.close();

            System.out.println("Image saved");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

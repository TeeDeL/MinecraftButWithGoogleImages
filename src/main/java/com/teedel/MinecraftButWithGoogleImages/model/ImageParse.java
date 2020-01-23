package com.teedel.MinecraftButWithGoogleImages.model;

import javafx.scene.control.TextArea;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ImageParse implements Runnable
{

/*


  private ImageResizeTool resize;

  public ImageParse(String searchTerm, String additionalPhrase, TextArea log, int imageDimension)
  {
    try
    {
      //Thread thread;
      //thread = new Thread(() -> {

      String url = "https://www.google.com/search?q=" + searchTerm + " " + additionalPhrase + "&tbm=isch";

      try
      {
        Document doc = null;
        try
        {
          doc = Jsoup.connect(url).timeout(20 * 1000).userAgent(userAgent).referrer("https://www.google.com/").get();
        }
        catch (Exception e)
        {
          System.err.println("READ TIMEOUT ERROR");
        }
        Elements elements = doc.select("div.rg_meta");

        JSONObject jsonObject;
        for (Element element : elements)
        {
          if (element.childNodeSize() > 0)
          {
            jsonObject = (JSONObject) new JSONParser().parse(element.childNode(0).toString());

            String urlString = (String) jsonObject.get("ou");
            if (urlString.endsWith(".png") || urlString.endsWith(".jpg"))
            {
              resultUrls.add(urlString);
            }
          }
        }

        System.out.println("List size: " + resultUrls.size());
        System.out.println("RNG: " + num);

        downloadImage(resultUrls.get(num), searchTerm, log);
        try
        {
          resize = new ImageResizeTool(imageDimension, new FormatFix().addUnderscore(searchTerm));
        }
        catch (Exception e)
        {
          //log.appendText(e.getLocalizedMessage());
        }
      }
      catch (ParseException e)
      {
        e.printStackTrace();
      }
      // });
      //thread.start();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public ImageParse(String name, TextArea log, int imageDimensions)
  {
    new ImageParse(name, "", log, imageDimensions);
  }
 */
  @Override
  public void run()
  {

  }

  public boolean isDone()
  {
    return true;
  }


}

package com.teedel.MinecraftButWithGoogleImages.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ImageParseHelper
{

  private String userAgent;
  private List<String> resultUrls;
  private String url;
  private String referrer;

  public ImageParseHelper(String searchTerm, String additionalPhrase)
  {
    userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36";
    resultUrls = new ArrayList<>();
    url = "https://www.google.com/search?q=" + searchTerm + " " + additionalPhrase + "&tbm=isch";
    referrer = "http://www.google.com";
  }

  public List<String> collectLinks()
  {
    try
    {
      Document doc = null;
      try
      {
        doc = Jsoup.connect(url).timeout(20 * 1000).userAgent(userAgent).referrer(referrer).get();
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
    }
    catch (ParseException e)
    {
      e.printStackTrace();
    }
    return resultUrls;
  }
}

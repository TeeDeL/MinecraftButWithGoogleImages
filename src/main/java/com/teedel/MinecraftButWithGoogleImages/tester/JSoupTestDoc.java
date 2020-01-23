package com.teedel.MinecraftButWithGoogleImages.tester;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JSoupTestDoc
{
  public static void main(String[] args)
  {
    Document doc;
    try
    {
      String url = "https://www.google.com/search?q=abucus&tbm=isch";
      String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36";

      //Document doc = Jsoup.connect(url).userAgent(userAgent).referrer("https://www.google.com/").get();
      doc = Jsoup.connect("http://google.ca/").timeout(5 * 1000).get();
      System.out.println(doc.html());
    } catch (Exception e)
    {
      System.err.println("Couldn't covnnect");
      e.printStackTrace();

    }
  }
}

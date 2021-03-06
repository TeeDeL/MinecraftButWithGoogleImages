package com.teedel.MinecraftButWithGoogleImages.model;

import com.teedel.MinecraftButWithGoogleImages.Launch.NameMapper;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppModel implements Runnable
{
  private NameMapper nameMapper;
  private ImageParseHelper iph;
  private DownloadHelper dh;
  private ExecutorService pool;
  private String additionalPhrase;
  private ImageResizeTool irt;
  private int count;

  public AppModel(String additionalPhrase)
  {
    nameMapper = new NameMapper();
    pool = Executors.newFixedThreadPool(10);
    this.additionalPhrase = additionalPhrase;
    count = 0;
  }
/*
  public void  startCreating(int dimension, int random)
  {
      pool.execute(() ->
      {
        for (String phrase : nameMapper.getNameList())
        {

        iph = new ImageParseHelper(phrase, additionalPhrase);
        dh = new DownloadHelper(iph.collectLinks());
        dh.downloadImage(phrase, random);
        irt = new ImageResizeTool(dimension, new FormatFix().addUnderscore(phrase));
        }
      });

  }

 */
  public void  startCreating(int dimension, int random, String path)
  {

    for (String phrase : nameMapper.getNameList()) {
      pool.execute(() ->
      {
        //TODO fix this.
        //iph = new ImageParseHelper(phrase, additionalPhrase);
        dh = new DownloadHelper(iph.collectLinks(), path);
        dh.downloadImage(phrase, random);
        new ImageResizeTool(dimension).resize(new FormatFix().addUnderscore(phrase), path);
      });
    }


  }

  public int getCount()
  {
    return count;
  }



  @Override
  public void run()
  {


  }
}

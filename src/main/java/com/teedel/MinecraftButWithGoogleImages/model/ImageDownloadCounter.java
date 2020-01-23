package com.teedel.MinecraftButWithGoogleImages.model;

public class ImageDownloadCounter
{
  private int count;

  public ImageDownloadCounter()
  {
    count = 0;
  }

  public void incrementCounter()
  {
    count++;
  }

  public int getCount()
  {
    return count;
  }

  public void setCount(int value)
  {
    count = value;
  }
}

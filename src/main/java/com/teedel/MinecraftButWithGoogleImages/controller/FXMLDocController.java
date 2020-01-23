package com.teedel.MinecraftButWithGoogleImages.controller;

import com.teedel.MinecraftButWithGoogleImages.model.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.simple.JSONObject;

public class FXMLDocController implements Initializable {

    @FXML private RadioButton radioButton32;
    @FXML private RadioButton radioButton64;
    @FXML private RadioButton radioButton128;
    @FXML private RadioButton radioButton256;
    @FXML private RadioButton radioButton512;
    @FXML private RadioButton radioButton1024;

    @FXML private RadioButton random4;
    @FXML private RadioButton random3;
    @FXML private RadioButton random2;
    @FXML private RadioButton random1;

    @FXML private TextArea consoleOut;

    @FXML private TextField tpName;
    @FXML private TextField tpExtraQuery;
    @FXML private ProgressBar dlProgressBar;

    private ToggleGroup tgRes = new ToggleGroup();
    private ToggleGroup tgRandom = new ToggleGroup();

    private ImageDownloadCounter count = new ImageDownloadCounter();

    private double maxImages = 0;
    private double stepCount = 0;
    private DoubleProperty progressCount;

    private String log = "";
    private String name = "";
    ExecutorService pool = Executors.newFixedThreadPool(6);
    private AppModel model;


    public int getResolution()
    {
        int res = 128;
        if (radioButton32.isSelected()) res = 32;
        if (radioButton64.isSelected()) res = 64;
        if (radioButton128.isSelected()) res = 128;
        if (radioButton256.isSelected()) res = 256;
        if (radioButton512.isSelected()) res = 512;
        if (radioButton1024.isSelected()) res = 1024;
        return res;
    }

    public int getRandomness()
    {
      int random = 5;
      if (random4.isSelected()) random = 1;
      if (random3.isSelected()) random = 4;
      if (random2.isSelected()) random = 8;
      if (random1.isSelected()) random = 16;

      return random;
    }



    public void createTPButton()
    {

      progressCount.setValue(0);
        NameMapper doa = new NameMapper();
      maxImages = doa.getNameList().size();
      stepCount = 1/maxImages;
      System.out.println(progressCount);

      this.model = new AppModel(tpExtraQuery.getText());
      model.startCreating(getResolution(), getRandomness());

/*
      for (String as : doa.getNameList()) {
          pool.execute(() ->
          {
              if (new ImageParse(as, tpExtraQuery.getText(), consoleOut, getResolution()).isDone() == true)
              {
                  progressCount.setValue(progressCount.getValue() + stepCount);
                System.out.println(progressCount);

              } else {
                System.err.println(progressCount);
              }
          });


      }
      */

    }

    public void log(String text)
    {
        consoleOut.appendText(text + "\n");
        log += text + "\n";
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {




        //Set up resolution radio buttons and toggle group
        radioButton128.setSelected(true);
        radioButton32.setToggleGroup(tgRes);
        radioButton64.setToggleGroup(tgRes);
        radioButton128.setToggleGroup(tgRes);
        radioButton256.setToggleGroup(tgRes);
        radioButton512.setToggleGroup(tgRes);
        radioButton1024.setToggleGroup(tgRes);

        random3.setSelected(true);
        random1.setToggleGroup(tgRandom);
        random2.setToggleGroup(tgRandom);
        random3.setToggleGroup(tgRandom);
        random4.setToggleGroup(tgRandom);


        consoleOut.setWrapText(false);
        consoleOut.setEditable(false);
        progressCount = new SimpleDoubleProperty();

        dlProgressBar.progressProperty().bind(progressCount);


    }
}

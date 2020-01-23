package com.teedel.MinecraftButWithGoogleImages.model;

import javafx.scene.control.TextArea;


public class TeeConsoleLog extends TextArea {

    String log;

    public TeeConsoleLog(String text)
    {
        log = text + "\n";

        this.appendText(text + "\n");
    }

    public void log(String text)
    {
        this.appendText(text + "\n");
        log += text + "\n";
    }

    public String getLog()
    {
        return log;
    }

}

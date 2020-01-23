package com.teedel.MinecraftButWithGoogleImages.Launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {

    private Parent root;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("core.fxml"));
        } catch (IOException e) {
            System.err.println("Could not load FXML");
        }
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void init()
    {

    }
}
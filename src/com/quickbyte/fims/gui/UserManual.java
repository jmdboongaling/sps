/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.fims.gui;

import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class UserManual extends Application {


  public static void main(String[] args) {
      launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
      primaryStage.setTitle("QuickByte Software - Makati Medical Center College Student Profiling System - Manual");
      URL x = getClass().getResource("/com/quickbyte/fims/resources/frameset.html");
      WebView myBrowser = new WebView();
      WebEngine myWebEngine = myBrowser.getEngine();
      myWebEngine.load(x.toExternalForm());
    
      StackPane root = new StackPane();
      root.getChildren().add(myBrowser);
      primaryStage.setScene(new Scene(root, 640, 480));
      primaryStage.show();
  }
}

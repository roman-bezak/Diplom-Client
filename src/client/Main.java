package client;

import client.controller.MainController;
import client.platform.SettingsConfig;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sun.net.www.http.HttpClient;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/main.fxml"));
        Parent root = loader.load();
        MainController controller = (MainController)loader.getController();

        Scene scene = new Scene(root);

        primaryStage.setTitle("Java code");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {



        //launch(args);
    }
}

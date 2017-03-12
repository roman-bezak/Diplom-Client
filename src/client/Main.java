package client;

import client.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("client/view/main.fxml"));
        Parent root = loader.load();
        MainController controller = (MainController)loader.getController();

        Scene scene = new Scene(root);

        primaryStage.setTitle("Java code");
        primaryStage.setScene(scene);
        primaryStage.show();


        primaryStage.setOnCloseRequest(we -> {
            controller.man.stop();
            System.out.println("Stage is closing");
        });

    }


    public static void main(String[] args) {



        launch(args);
    }
}

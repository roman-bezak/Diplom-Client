package client.controller;

import client.platform.SettingsConfig;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class SettingsController implements javafx.fxml.Initializable{

    public Stage settings_stage;
    public Scene scene;
    public SettingsConfig config;

    public void setUpSettingWindow(Parent p){

        scene = new Scene(p);
        settings_stage = new Stage();
        settings_stage.setScene(scene);
        settings_stage.setTitle("Settings");
        settings_stage.show();

    }

    public void showSettingsWindow(){
        settings_stage.show();
    }

    public void hideSettingWindow(){
        settings_stage.hide();
    }

    public void updateSettingsConfig(){
        config.saveSettingsConfig();
    }




    public void setOnClickSettingsOkButton(){
        //settingsController
    }
    public void setOnClickSettingsCancelButton(){
        this.hideSettingWindow();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("SC inithialize end.");
    }
}

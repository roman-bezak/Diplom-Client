package client.controller;

import client.platform.SettingsConfig;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class SettingsController implements javafx.fxml.Initializable{



    @FXML
    public javafx.scene.control.TextField s_address;
    @FXML
    public javafx.scene.control.TextField p_port;

    public Stage settings_stage;
    public Scene scene;
    public SettingsConfig config;

    public void setUpSettingWindow(Parent p){

        scene = new Scene(p);
        settings_stage = new Stage();
        settings_stage.setScene(scene);
        settings_stage.setTitle("Settings");

        settings_stage.getIcons().addAll(new Image(SettingsController.class.getResourceAsStream("../resources/add.png")));

        config = SettingsConfig.loadSettingsConfig();

        updateView();


    }

    public void showSettingsWindow(){
        this.updateView();
        settings_stage.show();
    }

    public void hideSettingWindow(){
        settings_stage.hide();
    }




    public void updateSettingsConfig(){
        config.updateSettingsConfig(s_address.getText(), Integer.valueOf(p_port.getText()));
    }



    public void updateView(){
        s_address.setText(config.server_address);
        p_port.setText(String.valueOf(config.port));
    }

    public void setOnClickSettingsOkButton(){
        this.updateSettingsConfig();
        this.hideSettingWindow();
    }
    public void setOnClickSettingsCancelButton(){
        this.hideSettingWindow();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("SC inithialize end.");
    }
}

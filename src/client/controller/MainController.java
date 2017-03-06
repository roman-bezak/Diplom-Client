package client.controller;

import client.platform.SettingsConfig;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements javafx.fxml.Initializable{


    @FXML
    private TableView table;

    public SettingsController settingsController;


    public void initialize(URL url, ResourceBundle rb) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/settings.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        settingsController = (SettingsController)loader.getController();
        settingsController.setUpSettingWindow(root);

        System.out.println("MC inithialize end.");
    }




}

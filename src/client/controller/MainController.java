package client.controller;

import client.platform.HttpRequester;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements javafx.fxml.Initializable{


    @FXML
    public TableView table;
    @FXML
    public ChoiceBox choice_box;


    public SettingsController settingsController;



    ObservableList<String> choice_box_options;

    public void initialize(URL url, ResourceBundle rb) {

        choice_box_options = FXCollections.observableArrayList("valuename1", "valuename2");
        choice_box.setItems(choice_box_options);
        choice_box.setValue(choice_box_options.get(0));


        choice_box.getSelectionModel().selectedIndexProperty().addListener((ov, value, new_value) -> {
            try {
                System.out.println(HttpRequester.sendGet("https://www.onliner.by"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });



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

    public void showSettingsWindow(){
        settingsController.showSettingsWindow();
    }

    public void choice_box_selected(){
        System.out.println("MC inithialize end.");
    }

}

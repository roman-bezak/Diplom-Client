package client.controller;

import client.platform.SettingsConfig;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class AddProjectController implements javafx.fxml.Initializable{



    @FXML
    public javafx.scene.control.ListView<String> list_view;
    @FXML
    public TextArea desc_text_area;
    @FXML
    public TextField url_text_field;
    @FXML
    public Button add_btn;
    @FXML
    public Button cancel_btn;

    public ObservableList<String> project_names = FXCollections.observableArrayList();
    public Stage addProject_stage;
    public Scene scene;

    public void setUpAddProjectWindow(Parent p){

        scene = new Scene(p);
        addProject_stage = new Stage();
        addProject_stage.setScene(scene);
        addProject_stage.setTitle("Add project");
        addProject_stage.setResizable(false);

        addProject_stage.getIcons().addAll(new Image(SettingsController.class.getResourceAsStream("../resources/add.png")));

        list_view.setItems(project_names);

        list_view.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {

                    System.out.println(list_view.getSelectionModel().getSelectedIndex());
                });

        //updateView();
    }

    public void showWindow(){
        //this.updateView();
        addProject_stage.show();
    }

    public void hideWindow(){
        for(int i=0; i < 30;i++)
            project_names.add(String.valueOf(i));
        addProject_stage.hide();
    }

    public void updateView(){
        //s_address.setText(config.server_address);
        //p_port.setText(String.valueOf(config.port));
    }

    public void setOnClickAddButton(){
        this.hideWindow();
    }
    public void setOnClickCancelButton(){
        this.hideWindow();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Add pr inithialize end.");
    }
}

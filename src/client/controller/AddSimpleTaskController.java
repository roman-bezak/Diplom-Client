package client.controller;


import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;


public class AddSimpleTaskController implements javafx.fxml.Initializable{

    @FXML
    private TextField taskName;
    @FXML
    private TextField taskFolder;
    @FXML
    private TextArea taskDescription;
    @FXML
    private CheckBox checkBoxNeedResult;
    @FXML
    private TextField resultFolder;
    @FXML
    private Button openTaskFolder;
    @FXML
    private Button openResultFolder;
    @FXML
    private Label resultLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("AddSimpleTaskController inithialize end.");
    }
}

package client.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements javafx.fxml.Initializable{


    @FXML
    private TableView table;


    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("<h1>This is my new Text</h1>");
    }


    public void p(){
        System.out.println("<h1>This is my new Text</h1>");
    }



}

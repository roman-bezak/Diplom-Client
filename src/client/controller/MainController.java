package client.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements javafx.fxml.Initializable{



    @FXML
    private TableView table;

    public TaskTableController t;
    public void initialize(URL url, ResourceBundle rb) {

        //t = new TaskTableController(table);
        System.out.println("<h1>This is my new Text</h1>");

    }


    public void p(){
        System.out.println("<h1>This is my new Text</h1>");
    }



}

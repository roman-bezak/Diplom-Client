package client.controller;

import client.platform.TaskManager;
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
import java.util.UUID;


public class MainController implements javafx.fxml.Initializable{


    @FXML
    public TableView table_view;
    @FXML
    public ChoiceBox choice_box;

    public TaskTableController task_table_controller;
    public SettingsController settingsController;
    public AddProjectController addProjectController;
    public TaskManager task_manager;

    ObservableList<String> choice_box_options;

    public void initialize(URL url, ResourceBundle rb) {


        task_manager = new TaskManager();
        task_table_controller = new TaskTableController(table_view, task_manager);

        choice_box_options = FXCollections.observableArrayList("valuename1", "valuename2");
        choice_box.setItems(choice_box_options);
        choice_box.setValue(choice_box_options.get(0));


        choice_box.getSelectionModel().selectedIndexProperty().addListener((ov, value, new_value) -> {

           task_manager.showTaskPool();
//            Thread thread = new Thread(){
//                public void run(){
//                    System.out.println("Thread Running");
//                    Runtime commandPrompt = Runtime.getRuntime();
//                    try {
//                        Process powershell = commandPrompt.exec("calc");
//                        int q =  powershell.waitFor();
//                        System.out.println(q);
//                    } catch (IOException e) {
//                        System.out.println(e.getMessage());
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            };
//
//            thread.start();

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

        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../view/addProject.fxml"));
        Parent root2 = null;

        try {
            root2 = loader2.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        addProjectController = (AddProjectController)loader2.getController();
        addProjectController.setUpAddProjectWindow(root2);
        addProjectController.getLinkOnTaskManager(task_manager);



        System.out.println("MC inithialize end.");
    }

    public void showSettingsWindow(){
        settingsController.showSettingsWindow();
    }
    public void showAddProjectWindow(){ addProjectController.showWindow(); }

    public void choice_box_selected(){
        System.out.println("MC inithialize end.");
    }

}

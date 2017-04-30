package client.controller;

import client.platform.Constants;
import client.platform.TaskManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;


public class MainController implements javafx.fxml.Initializable{


    @FXML
    public TableView table_view;
    @FXML
    public Button add_project_b;
    @FXML
    public Button run_task_b;
    @FXML
    public Button remove_task_b;
    @FXML
    public Button info_task_b;
    @FXML
    public Button task_folder_b;



    public TaskTableController task_table_controller;
    public SettingsController settingsController;
    public AddProjectController addProjectController;
    public TaskManager task_manager;
    public TopBarController top_bar;


    public void initialize(URL url, ResourceBundle rb) {

        top_bar = new TopBarController(add_project_b,run_task_b,remove_task_b,info_task_b,task_folder_b);
        task_manager = new TaskManager(top_bar);
        task_table_controller = new TaskTableController(table_view, task_manager);


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
        addProjectController.getLinkOnTableTaskController(task_table_controller);

       task_table_controller.tasks_list.get(0).start();

    }

    public void showSettingsWindow(){
        settingsController.showSettingsWindow();
    }
    public void showAddProjectWindow(){ addProjectController.showWindow(); }
    public void removeButtonClick(){

        int index = task_table_controller.table.getSelectionModel().getSelectedIndex();
        String task_nname = task_manager.pool.tasks.get(index).get("name").toString();

        task_manager.removeTask(task_nname);
        task_table_controller.removeTaskFromTableView(task_nname);

        if(task_manager.pool.tasks.size() == 0)top_bar.dizableAll();

    }

    public void openTaskFolder(){

        File file = new File(Constants.TASKS_FOLDER_PATH);
        String absolutePath = file.getAbsolutePath();

        Thread thread = new Thread(() -> {
            Process p = null;
            try {
                p = Runtime.getRuntime().exec("explorer " + absolutePath + "\\" +
                        task_table_controller.tasks_list.get(task_table_controller.table.getSelectionModel().getSelectedIndex()).folder_name);
                p.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(task_table_controller.tasks_list.get(task_table_controller.table.getSelectionModel().getSelectedIndex()).getTaskName());


        });


        thread.start();
    }


    public void showAbout(){

    }
    public void showTaskInfo(){

    }

    public 

}

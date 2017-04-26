package client.controller;

import client.platform.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
    public SettingsConfig config;
    public String server_response;
    public JSONArray json_response_array;

    public TaskManager task_manager;




    public void getLinkOnTaskManager(TaskManager __task_manager){
        this.task_manager = __task_manager;
    }

    public void setUpAddProjectWindow(Parent p){

        server_response = new String();

        scene = new Scene(p);
        addProject_stage = new Stage();
        addProject_stage.setScene(scene);
        addProject_stage.setTitle("Add project");
        addProject_stage.setResizable(false);

        config = SettingsConfig.loadSettingsConfig();

        addProject_stage.getIcons().addAll(new Image(SettingsController.class.getResourceAsStream("../resources/add.png")));
        list_view.setItems(project_names);
        list_view.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {

                    int temp = list_view.getSelectionModel().getSelectedIndex();
                    if(temp >= 0) {
                        setDescriptionBySelectedBroject(temp);
                        setUrlAddressById(temp);
                    }

                });

    }

    public void updateView() throws ParseException {

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(this.server_response);
        this.json_response_array = (JSONArray)obj;


        for(int i = 0; i < this.json_response_array.size(); i++) {
            JSONObject temp_obj = (JSONObject)this.json_response_array.get(i);
            project_names.add(temp_obj.get("name").toString());
        }

    }

    public void setDescriptionBySelectedBroject(int id){
        JSONObject temp_obj = (JSONObject)this.json_response_array.get(id);
        desc_text_area.setText(temp_obj.get("description").toString());
    }
    public void setUrlAddressById(int id){
        JSONObject temp_obj = (JSONObject)this.json_response_array.get(id);
        url_text_field.setText(temp_obj.get("url_site").toString());
    }

    public void showWindow(){


        JSONObject resultJson = new JSONObject();

        resultJson.put("name","GFSUUDFOGYHDS GH");
        resultJson.put("num",new Integer(100));

        task_manager.addTask(resultJson);

        config = SettingsConfig.loadSettingsConfig();
        addProject_stage.show();

        project_names.clear();
        list_view.getSelectionModel().select(null);

        try {

            this.server_response = HttpRequester.sendGet(config.server_address);
            updateView();

        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Server not responding");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

            this.hideWindow();
        }


    }


    public void addProject(int id){


        JSONObject temp_obj = (JSONObject)this.json_response_array.get(id);

        try {

            int task_random_id = ra
            HttpRequester.downloadFile(temp_obj.get("url_api").toString(), Constants.TASKS_FOLDER_PATH + "/" + "downloadFILE.rar");
            UnZip.unzip(Constants.TASKS_FOLDER_PATH + "/Downloads.zip", Constants.TASKS_FOLDER_PATH + "/folder");

        } catch (Exception e1) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("This project can not be added");
            alert.setContentText("Server not responding");
            alert.showAndWait();
        }

    }

    public void hideWindow(){
        addProject_stage.hide();
    }

    public void setOnClickAddButton(){
        addProject(list_view.getSelectionModel().getSelectedIndex());
    }
    public void setOnClickCancelButton(){
        this.hideWindow();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Add pr inithialize end.");
    }
}

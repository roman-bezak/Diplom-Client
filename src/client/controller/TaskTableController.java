package client.controller;

import client.platform.TaskManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class TaskTableController {


    public TableView table;
    public TaskManager task_manager;



    private final ObservableList<TasksInfoModel> tasks_list = FXCollections.observableArrayList();

    public TaskTableController(TableView table_link, TaskManager task_manager_link){

        table = table_link;
        task_manager = task_manager_link;


        this.setUpTableView();

        TableColumn id_col = new TableColumn("ID");
        id_col.setMaxWidth(36);
        id_col.setMinWidth(36);
        id_col.setSortable(false);
        id_col.setCellValueFactory(new PropertyValueFactory<TasksInfoModel, String>("id"));

        TableColumn name_col = new TableColumn("Project Name");
        name_col.setMaxWidth(250);
        name_col.setMinWidth(250);
        name_col.setSortable(false);
        name_col.setCellValueFactory(new PropertyValueFactory<TasksInfoModel, String>("taskName"));

        TableColumn url_col = new TableColumn("URL");
        url_col.setMaxWidth(228);
        url_col.setMinWidth(228);
        url_col.setSortable(false);
        url_col.setCellValueFactory(new PropertyValueFactory<TasksInfoModel, String>("urlSite"));

        TableColumn status_col = new TableColumn("Status");
        status_col.setMaxWidth(118);
        status_col.setMinWidth(118);
        status_col.setSortable(false);
        status_col.setStyle("-fx-alignment: CENTER;");
        status_col.setCellValueFactory(new PropertyValueFactory<TasksInfoModel, String>("status"));

        table.getColumns().add(id_col);
        table.getColumns().add(name_col);
        table.getColumns().add(url_col);
        table.getColumns().add(status_col);

        table.setItems(tasks_list);

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                System.out.println(table.getSelectionModel().getSelectedIndex());
            }
        });

    }

    public void setUpTableView(){

        for(int i = 0; i < task_manager.pool.tasks.size(); i++){
            tasks_list.add(new TasksInfoModel(String.valueOf(i + 1), task_manager.pool.tasks.get(i).get("name").toString(),
                                              task_manager.pool.tasks.get(i).get("url_site").toString(), "Stopped"));
        }

    }

    public static class TasksInfoModel {

        private final SimpleStringProperty id;
        private final SimpleStringProperty taskName;
        private final SimpleStringProperty urlSite;
        private final SimpleStringProperty status;

        private TasksInfoModel(String _id, String _taskName, String _urlSite, String _status) {

            this.id = new SimpleStringProperty(_id);
            this.taskName = new SimpleStringProperty(_taskName);
            this.urlSite = new SimpleStringProperty(_urlSite);
            this.status = new SimpleStringProperty(_status);

        }


        public void setId(String _id) {
            id.set(_id);
        }

        public String getId() {
            return id.get();
        }

        public void setTaskName(String _taskName) {
            taskName.set(_taskName);
        }

        public String getTaskName() {
            return taskName.get();
        }

        public void setUrlSite(String _urlSite) {
            urlSite.set(_urlSite);
        }

        public String getUrlSite() {
            return urlSite.get();
        }

        public void setStatus(String _status) {
            status.set(_status);
        }

        public String getStatus() {
            return status.get();
        }
    }

}

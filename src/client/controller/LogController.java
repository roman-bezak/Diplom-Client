package client.controller;


import javafx.scene.control.TextArea;

import java.awt.*;

public class LogController {

    public TextArea log_area;
    public Label down_label;

    public LogController(TextArea log_link,Label down_label_link){
        log_area = log_link;
        down_label = down_label_link;
    }


    public void writeToLog(String mess){
        log_area.appendText(mess);
    }


}

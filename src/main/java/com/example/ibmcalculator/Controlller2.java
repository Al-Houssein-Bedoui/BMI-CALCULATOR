package com.example.ibmcalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Controlller2 {

    @FXML
    private Button exit;

    @FXML
    void goback(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("ibm-view.fxml" , "IBM");

    }

}

package ru.project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ru.project.gui.GUI;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerIncorrectData implements Initializable {

    @FXML
    private Button cancelButton;

    @FXML
    private Button tryAgainButton;

    @FXML
    private void setTryAgainButton(){
        Stage stage = (Stage) tryAgainButton.getScene().getWindow();
        stage.close();
        new GUI().showInputMenu();
    }

    @FXML
    public void setCancelButton(){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) { }
}

package ru.project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.project.gui.GUI;
import ru.project.repository.Repository;
import ru.project.repository.UpdateData;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerUpdateData implements Initializable {

    @FXML
    private Button okButton;

    @FXML
    private TextField vinField;

    @FXML
    private TextField yearField;

    @FXML
    private TextField nameField;

    @FXML
    private void okButtonAction() {
        Repository repository = new Repository();
        UpdateData updateData = new UpdateData(repository);
        if (!(vinField.getText().equals("") || yearField.getText().equals("") || nameField.getText().equals(""))){
            updateData.updateData(vinField.getText(), yearField.getText(), nameField.getText());
            Stage stage = (Stage) okButton.getScene().getWindow();
            stage.close();
            new GUI().start(new Stage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) { }
}

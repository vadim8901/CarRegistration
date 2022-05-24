package ru.project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.project.gui.GUI;
import ru.project.repository.DeleteData;
import ru.project.repository.Repository;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerDeleteData implements Initializable {

    private Repository repository;
    private DeleteData deleteData;

    @FXML
    private Button buttonOk;

    @FXML
    private TextField vin;

    @FXML
    private void setButtonOk(){
        String text = vin.getText();
        repository = new Repository();
        deleteData = new DeleteData(repository);
        if (!text.equals("")){
            deleteData.deleteData(vin.getText());
            Stage stage = (Stage) buttonOk.getScene().getWindow();
            stage.close();
            new GUI().start(new Stage());
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {}
}

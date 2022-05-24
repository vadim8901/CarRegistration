package ru.project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.project.gui.GUI;
import ru.project.repository.AddData;
import ru.project.repository.Repository;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerInputData implements Initializable {
    private Repository repository;
    private AddData addData;

    @FXML
    private TextField inputBrand;

    @FXML
    private TextField inputModel;

    @FXML
    private TextField inputName;

    @FXML
    private TextField inputNumber;

    @FXML
    private TextField inputCountry;

    @FXML
    private TextField inputVIN;

    @FXML
    private TextField inputYear;

    @FXML
    private Button okButton;

    @FXML
    private void inputData(){
        Stage stage = (Stage) okButton.getScene().getWindow();
        repository = new Repository();
        addData = new AddData(repository);
        if (inputName.getText().equals("") || inputBrand.getText().equals("") ||
                inputVIN.getText().equals("") || inputNumber.getText().equals("") ||
                inputModel.getText().equals("") || inputCountry.getText().equals("") ||
                inputYear.getText().equals("")) {
            stage.close();
            new GUI().showIncorrectMenu();
        } else {
            repository.setAutoCommit(false);
            try {
                addData.addCarData(inputName.getText(), inputBrand.getText(),
                        inputVIN.getText(), inputNumber.getText(),
                        inputModel.getText(), inputCountry.getText(),
                        inputYear.getText());
                repository.commit();
            } catch(Exception e){
                repository.rollback();
                throw new RuntimeException("incorrect input data", e);
            } finally {
                new GUI().start(new Stage());
                repository.disconnect();
                stage.close();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) { }
}

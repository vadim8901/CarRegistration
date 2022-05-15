package ru.project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.project.GUI.GUI;
import ru.project.Repository.AddData;
import ru.project.Repository.Repository;

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

    private void inputData(){
        okButton.setOnAction(event -> {
            Stage stage = (Stage) okButton.getScene().getWindow();
                if (inputName.getText().equals("") || inputBrand.getText().equals("") ||
                        inputVIN.getText().equals("") || inputNumber.getText().equals("") ||
                        inputModel.getText().equals("") || inputCountry.getText().equals("") ||
                        inputYear.getText().equals("")) {
                    stage.close();
                    new GUI().showIncorrectMenu();
                } else {
                    try {
                    repository = new Repository();
                    addData = new AddData(repository);
                    addData.addData(inputName.getText(), inputBrand.getText(),
                            inputVIN.getText(), inputNumber.getText(),
                            inputModel.getText(), inputCountry.getText(),
                            inputYear.getText());
                } catch(Exception e){
                    System.out.println("Incorrect input data");
                    new GUI().showIncorrectMenu();
                } finally {
                        new GUI().start(new Stage());
                        stage.close();
                    }
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inputData();
    }
}

package ru.project.controllers;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ru.project.gui.GUI;
import ru.project.repository.Repository;
import ru.project.repository.SearchData;
import ru.project.entities.Car;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerMainMenu implements Initializable {

    private Repository repository;
    private ObservableList<Car> list;
    private SearchData searchData;

    @FXML
    private TableView<Car> carTable;

    @FXML
    private TableColumn<Car, String> VIN;

    @FXML
    private TableColumn<Car, String> brand;


    @FXML
    private TableColumn<Car, String> country;

    @FXML
    private TableColumn<Car, String> model;

    @FXML
    private TableColumn<Car, String> name;

    @FXML
    private TableColumn<Car, String> number;

    @FXML
    private TableColumn<Car, String> year;

    @FXML
    private Button newButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button updateButton;



    private void addDataInTable(){
        repository = new Repository();
        searchData = new SearchData(repository);
        try {
            list = searchData.searchFullData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        carTable.setItems(list);
    }

    @FXML
    private void clickNewData(){
            Stage stage = (Stage) newButton.getScene().getWindow();
            stage.close();
            new GUI().showInputMenu();
    }

    @FXML
    private void clickUpdateData(){
        Stage stage = (Stage) newButton.getScene().getWindow();
        stage.close();
        new GUI().showUpdateMenu();
    }

    @FXML
    private void clickDeleteData(){
        Stage stage = (Stage) newButton.getScene().getWindow();
        stage.close();
        new GUI().showDeleteMenu();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        VIN.setCellValueFactory(new PropertyValueFactory<Car, String>("VIN"));
        brand.setCellValueFactory(new PropertyValueFactory<Car, String>("brand"));
        country.setCellValueFactory(new PropertyValueFactory<Car, String>("country"));
        model.setCellValueFactory(new PropertyValueFactory<Car, String>("model"));
        name.setCellValueFactory(new PropertyValueFactory<Car, String>("name"));
        number.setCellValueFactory(new PropertyValueFactory<Car, String>("number"));
        year.setCellValueFactory(new PropertyValueFactory<Car, String>("year"));
        addDataInTable();
    }
}

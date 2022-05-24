package ru.project.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class GUI extends Application {

    private Stage primaryStage;
    private Stage inputStage;
    private Stage incorrectStage;
    private Stage deleteStage;
    private Stage updateStage;
    private final String tableCarPath = "/view/tableCar.fxml";
    private final String inputCarPath = "/view/inputCar.fxml";
    private final String incorrectDataPath = "/view/incorrectData.fxml";
    private final String deleteDataPath = "/view/deleteWindow.fxml";
    private final String updateDataPath = "/view/updateData.fxml";

    private FXMLLoader loader(Stage stage, String path){
        FXMLLoader loader = new FXMLLoader();
        try {
            VBox layout = loader.load(getClass().getResource(path));
            Scene scene = new Scene(layout);
            stage.setScene(scene);
        }catch (IOException e){
            e.printStackTrace();
        }
        return loader;
    }

    private void showMainMenu(){
        loader(primaryStage, tableCarPath);
        primaryStage.show();
    }

    public void showInputMenu(){
        inputStage = new Stage();
        loader(inputStage, inputCarPath);
        inputStage.setTitle("Input Data");
        inputStage.show();
    }

    public void showUpdateMenu(){
        updateStage = new Stage();
        loader(updateStage, updateDataPath);
        updateStage.setTitle("Update Data");
        updateStage.show();
    }

    public void showIncorrectMenu(){
        incorrectStage = new Stage();
        loader(incorrectStage, incorrectDataPath);
        incorrectStage.setTitle("Incorrect Data");
        incorrectStage.show();
    }

    public void showDeleteMenu(){
        deleteStage = new Stage();
        loader(deleteStage, deleteDataPath);
        deleteStage.setTitle("delete window");
        deleteStage.show();
    }



    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Car Application");
        showMainMenu();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

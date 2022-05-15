package ru.project.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.project.controllers.ControllerIncorrectData;
import ru.project.controllers.ControllerInputData;
import ru.project.controllers.ControllerMainMenu;

import java.io.IOException;

public class GUI extends Application {

    private Stage primaryStage;
    private Stage inputStage;
    private Stage incorrectStage;

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
            FXMLLoader loader = loader(primaryStage, "/view/tableCar.fxml");
            ControllerMainMenu controller = loader.getController();
            primaryStage.show();
    }

    public void showInputMenu(){
            inputStage = new Stage();
            FXMLLoader loader = loader(inputStage, "/view/inputCar.fxml");
            inputStage.setTitle("Input Data");
            ControllerInputData controller = loader.getController();
            inputStage.show();
    }

    public void showIncorrectMenu(){
        incorrectStage = new Stage();
        FXMLLoader loader = loader(incorrectStage, "/view/incorrectData.fxml");
        incorrectStage.setTitle("Incorrect Data");
        ControllerIncorrectData controller = loader.getController();
        incorrectStage.show();
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

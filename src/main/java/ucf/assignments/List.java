package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Alex Galvez-Vega
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class List extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ListController.fxml"));


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("List Operations");
        primaryStage.show();
    }
    //Main Area
    //Start Area
    //adding here
}

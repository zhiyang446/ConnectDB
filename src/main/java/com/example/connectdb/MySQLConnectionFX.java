package com.example.connectdb;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnectionFX extends Application {

    Label label;

    @Override
    public void start(Stage stage) {

        label = new Label();

        StackPane layout = new StackPane(label);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 150);
        stage.setScene(scene);
        stage.show();

        Connection conn = getConnection();
        if (conn != null) {
            label.setText("Connected to Database!");
        } else {
            label.setText("Error Connecting to Database.");
        }
    }

    public Connection getConnection() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/testing", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
package com.example.demo6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20));
        pane.setVgap(10);
        pane.setHgap(10);

        Label lb1 = new Label("Decimal :");
        Label lb2 = new Label("Binary   :");
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        Button bt = new Button("Start");
        bt.setPrefSize(50,40);
        tf1.setPrefSize(50,40);
        tf2.setPrefSize(50,40);
        pane.addColumn(0,lb1,lb2);
        pane.addColumn(1,tf1,tf2,bt);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane,300,300);
        stage.setScene(scene);
        stage.setTitle("Converter");
        stage.show();

        bt.setOnAction(e->{
//            String binary = Integer.toBinaryString(Integer.parseInt(tf1.getText()));
//            tf2.setText(binary);
            int decimal = Integer.parseInt(tf1.getText());
            String semiBinary = "";
            while (decimal > 0) {

                if (decimal % 2 == 0) {
                    decimal = decimal / 2;
                    semiBinary += "0";
                } else {
                    decimal = ((decimal - 1) / 2);
                    semiBinary += "1";
                }
            }
            StringBuilder sb = new StringBuilder(semiBinary);
            sb.reverse();
            String binary = sb.toString();
            tf2.setText(binary);
        });

    }

    public static void main(String[] args) {
        launch();
    }
}
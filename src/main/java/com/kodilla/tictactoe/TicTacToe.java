package com.kodilla.tictactoe;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class TicTacToe extends Application {

    private Tile[][] board = new Tile[3][3];
    private Label lblStatus = new Label("X's turn to play");



    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pane.add(board[i][j] = new Tile(), j, i);
            }
        }
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(lblStatus);

        Scene scene = new Scene(borderPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("TicTacToe");
        primaryStage.show();
    }


    private class Tile extends StackPane {
        private Text tex = new Text();

        public Tile() {



            Rectangle border = new Rectangle(200, 200);
            Text text = new Text();
            text.setFont(Font.font(80));
            border.setFill(Color.LIGHTBLUE);
            border.setStroke(Color.BLACK);
            setAlignment(Pos.CENTER);

            getChildren().addAll(border,text, tex);

            setOnMouseClicked( e -> {
                if(e.getButton() == MouseButton.PRIMARY) {
                    tex.setText("d");

                    if(  board[2][2].contains(2,2)) {
                        board[1][1].tex.setText("d");
                    }


                }

            });

        }
    }
}

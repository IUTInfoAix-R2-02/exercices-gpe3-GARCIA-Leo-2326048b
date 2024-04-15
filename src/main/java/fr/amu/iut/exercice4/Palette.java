package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private Label label;
    private Pane panneau;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root,400,200);
        primaryStage.setScene(scene);

        label = new Label();
        BorderPane.setAlignment(label,Pos.CENTER);

        panneau = new Pane();

        HBox bas = new HBox();
        bas.setAlignment(Pos.CENTER);
        bas.setPadding(new Insets(10));
        vert = new Button("vert");
        rouge = new Button("rouge");
        bleu = new Button("bleu");

        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            nbVert++;
            label.setText(vert.getText()+" choisi "+nbVert+" fois");
            panneau.setStyle("-fx-background-color: green");
        });
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            nbRouge++;
            label.setText(rouge.getText()+" choisi "+nbRouge+" fois");
            panneau.setStyle("-fx-background-color: red");
        });
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            nbBleu++;
            label.setText(bleu.getText()+" choisi "+nbBleu+" fois");
            panneau.setStyle("-fx-background-color: blue");
        });
        bas.setSpacing(10);
        bas.getChildren().addAll(vert,rouge,bleu);

        root.setTop(label);
        root.setCenter(panneau);
        root.setBottom(bas);

        primaryStage.show();
    }
}


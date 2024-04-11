package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        // code de l'exercice 1
        BorderPane fenetre = new BorderPane();
        Scene scene = new Scene(fenetre,1020,768);
        primaryStage.setScene(scene);

        Menu file = new Menu("File");
        MenuItem file1 = new MenuItem("New");
        MenuItem file2 = new MenuItem("Open");
        MenuItem file3 = new MenuItem("Save");
        MenuItem file4 = new MenuItem("Close");
        SeparatorMenuItem separator1 = new SeparatorMenuItem();
        SeparatorMenuItem separator2 = new SeparatorMenuItem();
        SeparatorMenuItem separator3 = new SeparatorMenuItem();
        file.getItems().addAll(file1, separator1, file2, separator2, file3, separator3, file4);
        Menu edit = new Menu("Edit");
        MenuItem edit1 = new MenuItem("Open");
        MenuItem edit2 = new MenuItem("Save");
        MenuItem edit3 = new MenuItem("Close");
        SeparatorMenuItem separator4 = new SeparatorMenuItem();
        SeparatorMenuItem separator5 = new SeparatorMenuItem();
        edit.getItems().addAll(edit1, separator4, edit2, separator5, edit3);
        Menu help = new Menu("Help");
        MenuBar menuBar = new MenuBar(file, edit, help);

        VBox center = new VBox();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        center.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        Label userName = new Label("Name:");
        grid.add(userName, 0, 1);
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);
        Label mail = new Label("Mail:");
        grid.add(mail, 0, 2);
        TextField mailText = new TextField();
        grid.add(mailText, 1, 2);
        Label pw = new Label("Password:");
        grid.add(pw, 0, 3);
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 3);
        HBox boutonsCenter = new HBox();
        Button submit = new Button("Submit");
//        HBox.setMargin( submit, new Insets(0.0d, 10.0d, 0.0d, 0.0d) );
        Button cancel = new Button("Cancel");
        boutonsCenter.setAlignment(Pos.CENTER);
        boutonsCenter.getChildren().addAll(submit,cancel);
        center.getChildren().addAll(grid,boutonsCenter);


        HBox left = new HBox();
        VBox boutons = new VBox();
        boutons.setAlignment(Pos.CENTER);
        Label labelBoutons = new Label("Boutons :");
        Button bouton1 = new Button("Bouton 1");
        Button bouton2 = new Button("Bouton 2");
        Button bouton3 = new Button("Bouton 3");
        VBox.setMargin( labelBoutons, new Insets(0.0d, 0.0d, 10.0d, 0.0d) );
        VBox.setMargin( bouton1, new Insets(0.0d, 0.0d, 10.0d, 0.0d) );
        VBox.setMargin( bouton2, new Insets(0.0d, 0.0d, 10.0d, 0.0d) );
        VBox.setMargin( bouton3, new Insets(0.0d, 0.0d, 10.0d, 0.0d) );
        boutons.getChildren().addAll(labelBoutons, bouton1, bouton2, bouton3);
        Separator separatorCenter = new Separator(Orientation.VERTICAL);
        left.getChildren().addAll(boutons,separatorCenter);


        VBox bottom = new VBox();
        bottom.setAlignment(Pos.BOTTOM_CENTER);
        Label labelBas = new Label("Ceci est un label de bas de page");
        Separator separatorBottom = new Separator(Orientation.HORIZONTAL);
        bottom.getChildren().addAll(separatorBottom,labelBas);


        fenetre.setTop(menuBar);
        fenetre.setCenter(center);
        fenetre.setLeft(left);
        fenetre.setBottom(bottom);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}


package fr.amu.iut.exercice7;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CounterController implements Initializable {

    @FXML
    private Label counterLabel;

    private int counter = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialiser le texte du Label avec "0"
        counterLabel.setText("0");
    }

    // Méthode pour incrémenter le compteur
    @FXML
    public void increment() {
        counter++;
        counterLabel.setText(String.valueOf(counter));
    }

    // Méthode pour décrémenter le compteur
    @FXML
    public void decrement() {
        counter--;
        counterLabel.setText(String.valueOf(counter));
    }
}

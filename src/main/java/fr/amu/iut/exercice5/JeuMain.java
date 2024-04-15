package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;

    private Obstacle obstacle;


    private double posXj1;
    private double posYj1;
    private double posXj2;
    private double posYj2;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        //Obstacles
        obstacle = new Obstacle( 300,200,100,300);




        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        jeu.getChildren().add(obstacle);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());
                    break;
                case Q:
                    j2.deplacerAGauche();
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight());
                    break;

            }
            if (j1.estEnCollision(j2)) {
                System.out.println("Collision....");
                Platform.exit();
            } else if (obstacle.estEnCollision(j1)) {
                System.out.println("Collision....");
                j1.setLayoutX(posXj1);
                j1.setLayoutY(posYj1);
            } else if (obstacle.estEnCollision(j2)) {
                System.out.println("Collision....");
                j2.setLayoutX(posXj2);
                j2.setLayoutY(posYj2);
            } else {
                posXj1 = j1.getLayoutX();
                posYj1 = j1.getLayoutY();
                posXj2 = j2.getLayoutX();
                posYj2 = j2.getLayoutY();
            }
        });
    }


}

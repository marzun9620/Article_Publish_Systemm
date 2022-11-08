package com.example.log_reg;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
public class WriterController implements Initializable{
    @FXML
    private ImageView exit,menu;

    @FXML
    private AnchorPane pane1,pane2;

    @FXML
    private ImageView home;

    @FXML
    private ImageView logout;

    @FXML
    private ImageView writing;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


       exit.setOnMouseClicked(event -> {
           System.exit(0);
       });
       pane1.setVisible(false);

        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.5),pane1);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.5),pane2);
        translateTransition.setByX(-600);
        translateTransition.play();

        menu.setOnMouseClicked(event -> {
            pane1.setVisible(true);
            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),pane1);
            fadeTransition1.setFromValue(1);
            fadeTransition1.setToValue(0.15);
            fadeTransition1.play();

            TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),pane2);
            translateTransition1.setByX(+600);
            translateTransition1.play();
        });

        pane1.setOnMouseClicked(event -> {
            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),pane1);
            fadeTransition1.setFromValue(1);
            fadeTransition1.setToValue(0.15);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                pane1.setVisible(false);
            });

            TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),pane2);
            translateTransition1.setByX(-600);
            translateTransition1.play();

        });


        File showTopFile = new File("image/HomePage.png");
        Image showTopImage = new Image(showTopFile.toURI().toString());
        home.setImage(showTopImage);

        File showUserFile = new File("image/writing.png");
        Image showUserImage = new Image(showUserFile.toURI().toString());
        writing.setImage(showUserImage);

        File showLockFile = new File("image/logout.png");
        Image showLockImage = new Image(showLockFile.toURI().toString());
        logout.setImage(showLockImage);

        File showCrossFile = new File("image/cross.png");
        Image showCrossImage = new Image(showCrossFile.toURI().toString());
        exit.setImage(showCrossImage);

        File showMenuFile = new File("image/burger_menu.png");
        Image showMenuImage = new Image(showMenuFile.toURI().toString());
        menu.setImage(showMenuImage);
    }
}

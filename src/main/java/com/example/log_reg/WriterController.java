package com.example.log_reg;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriterController implements Initializable{
    @FXML
    private AnchorPane ap,ap1;
    @FXML
    private ImageView exit,menu;

    @FXML
    private AnchorPane pane1,pane2;

    @FXML
    private ImageView profile;
    @FXML
    private JFXButton back;

    @FXML
    private ImageView back_image;

    @FXML
    private ImageView logout;

    @FXML
    private ImageView compose;
    @FXML
    private ImageView inbox;
    @FXML
    private JFXButton inbox1;

    @FXML
    private JFXButton profile1;

    @FXML
    private JFXButton compose1;

    @FXML
    private JFXButton logout1;



    @Override
    public void initialize(URL location, ResourceBundle resources) {


        pane1.setVisible(false);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), pane1);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), pane2);
        translateTransition.setByX(-600);
        translateTransition.play();

        menu.setOnMouseClicked(event -> {
            pane1.setVisible(true);
            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), pane1);
            fadeTransition1.setFromValue(1);
            fadeTransition1.setToValue(0.15);
            fadeTransition1.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), pane2);
            translateTransition1.setByX(+600);
            translateTransition1.play();
        });

        pane1.setOnMouseClicked(event -> {
            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), pane1);
            fadeTransition1.setFromValue(1);
            fadeTransition1.setToValue(0.15);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                pane1.setVisible(false);
            });

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), pane2);
            translateTransition1.setByX(-600);
            translateTransition1.play();

        });


        File showTopFile = new File("image/writer/icons8-users-96.png");
        Image showTopImage = new Image(showTopFile.toURI().toString());
        profile.setImage(showTopImage);

        File showUserFile = new File("image/writer/inbox.png");
        Image showUserImage = new Image(showUserFile.toURI().toString());
        inbox.setImage(showUserImage);

        File showLockFile = new File("image/writer/compose.png");
        Image showLockImage = new Image(showLockFile.toURI().toString());
        compose.setImage(showLockImage);

        File showCrossFile = new File("image/logout.png");
        Image showCrossImage = new Image(showCrossFile.toURI().toString());
        logout.setImage(showCrossImage);

        File showMenuFile = new File("image/burger_menu.png");
        Image showMenuImage = new Image(showMenuFile.toURI().toString());
        menu.setImage(showMenuImage);


        File showCross1File = new File("image/cross.png");
        Image showCross1Image = new Image(showCross1File.toURI().toString());
        exit.setImage(showCross1Image);

        File showBack1File = new File("go_back.png");
        Image showBackImage = new Image(showBack1File.toURI().toString());
        back_image.setImage(showBackImage);
    }

    @FXML
    void profile(MouseEvent event) throws IOException {
        Node node;
        node=(Node)FXMLLoader.load(getClass().getResource("writer_profile.fxml"));
        ap.getChildren().setAll(node);
    }

    @FXML
    void compose(MouseEvent event) throws IOException {
        Node node;
        node=(Node)FXMLLoader.load(getClass().getResource("writearticle.fxml"));
        ap.getChildren().setAll(node);
    }

    @FXML
    void inbox(MouseEvent event) throws IOException {
        Node node;
        node=(Node)FXMLLoader.load(getClass().getResource("writer_inbox.fxml"));
        ap.getChildren().setAll(node);
    }

    @FXML
    void logout(MouseEvent event) throws IOException {
        try{
            FXMLLoader fxmlRegLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            Stage registrationStage = new Stage();
            registrationStage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene Regscene = new Scene(fxmlRegLoader.load());
            // registrationStage.initStyle(StageStyle.UNDECORATED);
            registrationStage.setScene(Regscene);
            registrationStage.show();

        }catch(Exception ex){
            ex.printStackTrace();
            ex.getCause();
        }
    }
    @FXML
    void cross(MouseEvent event) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }
    @FXML
    void back(MouseEvent event) {
        try{
            FXMLLoader fxmlRegLoader = new FXMLLoader(getClass().getResource("Writer.fxml"));
            Stage registrationStage = new Stage();
            registrationStage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene Regscene = new Scene(fxmlRegLoader.load());
            // registrationStage.initStyle(StageStyle.UNDECORATED);
            registrationStage.setScene(Regscene);
            registrationStage.show();

        }catch(Exception ex){
            ex.printStackTrace();
            ex.getCause();
        }
    }


   /* public void loadPage(String page) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("Writer.fxml"));
       try{
            root= FXMLLoader.load(getClass().getResource(page+".fxml"));
        }catch (IOException ex){
            //Logger.getLogger(WriterController.class.getName()).log(Level.SEVERE,null,ex);
        }
        ap1.setClip(root);
    }*/


}
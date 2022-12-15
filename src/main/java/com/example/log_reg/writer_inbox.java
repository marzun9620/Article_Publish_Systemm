package com.example.log_reg;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class writer_inbox implements Initializable {


    @FXML
    private  Label textField3;

    public static Label uss;



    @FXML
    private ImageView writerarticleimage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textField3=uss;
        File showLockFile = new File("bg.jpg");
        Image showLockImage = new Image(showLockFile.toURI().toString());
        writerarticleimage.setImage(showLockImage);

    }


    public static void SetText(){
        //if(textField3 !=null){
        //textField3.setText("Congrats Your Writing Got Published!!!!");
        // }

    }
}

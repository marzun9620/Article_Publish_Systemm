package com.example.log_reg;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class writer_inbox implements Initializable {


    @FXML
    private static Text textField1;

    @FXML
    private ImageView writerarticleimage;
    public static void setText(String w){
         textField1.setText(w);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File showLockFile = new File("bg.jpg");
        Image showLockImage = new Image(showLockFile.toURI().toString());
        writerarticleimage.setImage(showLockImage);
    }
}

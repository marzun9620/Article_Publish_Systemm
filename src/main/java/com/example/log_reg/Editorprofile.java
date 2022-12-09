package com.example.log_reg;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Editorprofile implements Initializable {

    @FXML
    private Button closebutton;
    @FXML
    private ImageView editor;

    @FXML
    void editorprofileclose(MouseEvent event) {
        Stage stage = (Stage) closebutton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File showUserFile = new File("image/editor/profile.png");
        Image showUserImage = new Image(showUserFile.toURI().toString());
        editor.setImage(showUserImage);

    }
}

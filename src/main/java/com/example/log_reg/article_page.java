package com.example.log_reg;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;



public class article_page implements Initializable {
    @FXML
    public  TextArea text1;
    @FXML
    private TextArea text2;
    @FXML
    private TextArea text3;

    @FXML
    private ImageView addImage;
    @FXML
    private Label trending;


    @FXML
    private ImageView browseImage;

    @FXML
    private Label cross,browse;

    @FXML
    private ImageView crossImage;

    @FXML
    private ImageView favImage;
    @FXML
    private Text joinus;

    @FXML
    private ImageView historyImage;

    @FXML
    private ImageView joinusImage;

    @FXML
    private ImageView prevReadImage;

    @FXML
    private ImageView searchImage;


    @FXML
    private ImageView trendImage;
    File f=new File("/home/marzun/Downloads/MIST/2-2/OOP-220/Projrct_Article_Publish_system/log_reg/FileInfo/writer.txt");
    public void Readtext(File f)throws IOException{
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) !=null){
            text1.setText(line);
        }
        br.close();
        fr.close();
    }

    @FXML
    void closeWindow(MouseEvent event) {
        Stage stage = (Stage) cross.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File showTopFile = new File("New_image/cross.png");
        Image showTopImage = new Image(showTopFile.toURI().toString());
      crossImage.setImage(showTopImage);

        File BrowseFile = new File("New_image/browse.png");
        Image BrowseImage = new Image(BrowseFile.toURI().toString());
        browseImage.setImage(BrowseImage);


        File trendFile = new File("New_image/article_page_tending.png");
        Image trendImage1 = new Image(trendFile.toURI().toString());
     trendImage.setImage(trendImage1);

        File showAddyoursFile = new File("New_image/add.png");
        Image showAddyoursImage = new Image(showAddyoursFile.toURI().toString());
        addImage.setImage(showAddyoursImage);

        File showprevFile = new File("New_image/read.png");
        Image showprevImage = new Image(showprevFile.toURI().toString());
       prevReadImage.setImage(showprevImage);

        File showfavFile = new File("New_image/fav.png");
        Image showfavImage = new Image(showfavFile.toURI().toString());
        favImage.setImage(showfavImage);

        File showhistoryFile = new File("New_image/history.png");
        Image showhistoryImage = new Image(showhistoryFile.toURI().toString());
        historyImage.setImage(showhistoryImage);

        File showUsFile = new File("New_image/us.png");
        Image showUsImage = new Image(showUsFile.toURI().toString());
        joinusImage.setImage(showUsImage);

        File showsearchFile = new File("New_image/article_page_search.png");
        Image showsearchImage = new Image(showsearchFile.toURI().toString());
        searchImage.setImage(showsearchImage);
    }

    @FXML
    void gotToLoginPage(MouseEvent event) {
        try{
            FXMLLoader fxmlRegLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            Stage registrationStage = new Stage();
            registrationStage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene Regscene = new Scene(fxmlRegLoader.load());
            registrationStage.setScene(Regscene);
            registrationStage.show();

        }catch(Exception ex){
            ex.printStackTrace();
            ex.getCause();
        }
    }

    @FXML
    void SetText(MouseEvent event) throws IOException {
         Readtext(f);
    }

}

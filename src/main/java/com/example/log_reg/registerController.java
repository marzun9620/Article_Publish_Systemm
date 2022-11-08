package com.example.log_reg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class registerController implements Initializable {
    int in;
    String Username,Password,usr,pass,emmail;
    @FXML
    private Button userRegCancel;

    @FXML
    private TextField userRegEmail;

    @FXML
    private ImageView userRegImage;

    @FXML
    private TextField userRegName;

    @FXML
    private PasswordField userRegPass;

    @FXML
    private Button userRegSignUp;
    @FXML
    private ImageView showRegImageView;
    @FXML
    private ImageView showTopImageView;

    private Parent root;
    @FXML
    TableColumn<writers_info, String> name;

    @FXML
    TableView<writers_info> table;
    @FXML
    TableColumn<writers_info, String> action;
    File f = new File("/home/marzun/Downloads/MIST/2-2/OOP-220/Projrct_Article_Publish_system/log_reg/FileInfo/");

    void createFolder(){
        if(!f.exists()){
            f.mkdirs();
        }
    }

    void readFile() {
        try {
            FileReader fr = new FileReader(f + "/logins.txt");
            System.out.println("File Exits..");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f + "/logins.txt");
                System.out.println("File created..");
            } catch (IOException ex1) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex1);

            }
        }
    }
    void countLines(){
        try{
            in=1;
            RandomAccessFile raf = new RandomAccessFile(f + "/logins.txt","rw");
            for(int i=0;raf.readLine()!=null;i++){
                in++;
            }
        }catch(FileNotFoundException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    void addData(String usr , String pass ,String email){
        try{
            RandomAccessFile raf = new RandomAccessFile(f+"/logins.txt", "rw");
            for(int i=0;i<in;i++){
                raf.readLine();
            }

            raf.writeBytes("Username:"+usr+"\r\n");
            raf.writeBytes("Password:"+pass+"\r\n");
            raf.writeBytes("Email:"+email+"\r\n");
            raf.writeBytes("\r\n");
            //raf.writeBytes("Email: "+mail);
        }catch(FileNotFoundException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File showRegFile = new File("image/reg1.jpg");
        Image showRegImage = new Image(showRegFile.toURI().toString());
        showRegImageView.setImage(showRegImage);

        File showTopFile = new File("image/reg.png");
        Image showTopImage = new Image(showTopFile.toURI().toString());
        showTopImageView.setImage(showTopImage);
    }
    public void userRegCancelOnAction(ActionEvent event){
        Stage stage = (Stage) userRegCancel.getScene().getWindow();
        stage.close();
    }

    public void userRegSignUpOnAction(ActionEvent event) throws IOException{
        //createFolder();
        //readFile();
        countLines();
        usr=userRegName.getText();
        pass=userRegPass.getText();
        emmail=userRegEmail.getText();
        addData(usr,pass,emmail);

        FXMLLoader loader= new FXMLLoader(getClass().getResource("Editor.fxml"));
        root = loader.load();
        EditorController editorController=loader.getController();
        editorController.setData(usr,pass,emmail);


        try{
            FXMLLoader fxmlRegLoader = new FXMLLoader(getClass().getResource("Editor.fxml"));
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
}

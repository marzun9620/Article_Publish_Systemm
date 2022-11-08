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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class Controller implements Initializable {
    String Username,Password,usr,pass;
    double x,y = 0;
    int in;
    private Parent root;
    @FXML
    private Button cancelButton;


    @FXML
    private Text LoginMessege;
    @FXML
    private ImageView showTopImageView;
    @FXML
    private ImageView userImageView;
    @FXML
    private ImageView lockImageView;
    @FXML
    public TextField loginText;
    @FXML
    private PasswordField passText;
    @FXML
    private Button clickRegister;


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

    void addData(String usr , String pass ){
        try{
            RandomAccessFile raf = new RandomAccessFile(f+"/logins.txt", "rw");
            for(int i=0;i<in;i++){
                raf.readLine();
            }
            raf.writeBytes("\r\n");
            raf.writeBytes("Username:"+usr+"\r\n");
            raf.writeBytes("Password:"+pass+"\r\n");
            //raf.writeBytes("Email: "+mail);
        }catch(FileNotFoundException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void CheckData(String usr,String pawd){
        try{
            RandomAccessFile raf = new RandomAccessFile(f+"/logins.txt", "rw");
            String line = raf.readLine();
            Username=line.substring(9);
            Password=raf.readLine().substring(9);
            if(usr.equals(Username) && pawd.equals(Password)){
                JOptionPane.showMessageDialog(null,"Password matched");
            }else{
                JOptionPane.showMessageDialog(null,"Worng Password");
            }
        }catch(FileNotFoundException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void logic(String usr ,String pawd){
        try{
            RandomAccessFile raf =new RandomAccessFile(f+"/logins.txt","rw");
            for(int i=1;i<=in;i+=4){
                String forUser=raf.readLine().substring(9);
                String forPawd=raf.readLine().substring(9);
                if(usr.equals(forUser) && pawd.equals(forPawd)){
                    JOptionPane.showMessageDialog(null,"Password matched");
                    break;
                   // return true;
                }else if(i==(in-4)){
                    JOptionPane.showMessageDialog(null,"Worng Password");
                    break;
                   // return false;
                }
                for(int k=1;k<=2;k++){
                    raf.readLine();
                }
            }
        }catch(FileNotFoundException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return false;
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



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File showTopFile = new File("image/Article-Writing-1200x675.png");
        Image showTopImage = new Image(showTopFile.toURI().toString());
        showTopImageView.setImage(showTopImage);

        File showUserFile = new File("image/user-login-icon-14.png");
        Image showUserImage = new Image(showUserFile.toURI().toString());
        userImageView.setImage(showUserImage);

        File showLockFile = new File("image/480-4809465_black-clip-art-ⓒ-change-password-icon-png.png");
        Image showLockImage = new Image(showLockFile.toURI().toString());
        lockImageView.setImage(showLockImage);
    }
    public void loginButtonOnAction(ActionEvent event) throws SQLException, IOException {
        //if(loginText.getText().isBlank()==false && passText.getText().isBlank()==false){
            //validlogin();
       // }else {
            //LoginMessege.setText("You are trying to Login!!");
        //}
        createFolder();
        readFile();
        countLines();
        //addData("marjana" , "shamsun99");
        usr=loginText.getText();
        pass=passText.getText();
        logic(usr,pass);


        /*StringBuilder sb = new StringBuilder();
        sb.append(loginText.getText().toString()+"\n");
        sb.append(passText.getText().toString());

        File file = new File("/home/marzun/login.txt");
        FileWriter w = new FileWriter(file);
        w.write(sb.toString());
        w.close();*/
        try{
            /*FXMLLoader fxmlRegLoader = new FXMLLoader(getClass().getResource("Editor.fxml"));
            Stage registrationStage = new Stage();
            registrationStage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene Regscene = new Scene(fxmlRegLoader.load());
            // registrationStage.initStyle(StageStyle.UNDECORATED);
            registrationStage.setScene(Regscene);
            registrationStage.show();*/


            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Editor.fxml")));
            Stage primaryStage = new Stage();
            Scene sc = new Scene(root);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            root.setOnMouseClicked(event1 -> {
                x = event1.getSceneX();
                y = event1.getSceneY();
            });
            root.setOnMouseDragged(event1 -> {
                primaryStage.setX(event1.getSceneX()-x);
                primaryStage.setY(event1.getSceneY()-y);
            });


            primaryStage.setScene(sc);
            primaryStage.show();

        }catch(Exception ex){
            ex.printStackTrace();
            ex.getCause();
        }

    }
    public void writerButtonOnAction(ActionEvent event) throws IOException{

    }


    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void clickRegisterOnAction(ActionEvent event) throws IOException{
          try{
            FXMLLoader fxmlRegLoader = new FXMLLoader(getClass().getResource("register.fxml"));
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

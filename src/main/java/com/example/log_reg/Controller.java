package com.example.log_reg;


import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.input.MouseEvent;
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
    int in,in1;
    private Parent root;
    @FXML
    private Button cancelButton;


    @FXML
    private JFXButton user;
    @FXML
    private JFXButton admin;


    @FXML
    private Text LoginMessege;
    @FXML
    private ImageView showTopImageView;
    @FXML
    private ImageView userImageView;
    @FXML
    private ImageView purple;
    @FXML
    public TextField loginText;
    @FXML
    private PasswordField passText;
    @FXML
    private Button clickRegister;
    @FXML
    private JFXButton gotoMagazine;



    File f = new File("FileInfo");
    File f1 = new File("FileInfo");

    void createFolder(){
        if(!f.exists()){
            f.mkdirs();
        }
        if(!f1.exists()){
            f1.mkdirs();
        }
    }
    void readFile() {
        try {
            FileReader fr = new FileReader(f + "/logins.txt");
            //System.out.println("File Exits..");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f + "/logins.txt");
                //System.out.println("File created..");
            } catch (IOException ex1) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex1);

            }
        }
    }
    void readFile1() {
        try {
            FileReader fr = new FileReader(f1 + "/logins_witer.txt");
            //System.out.println("File Exits..");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f1 + "/logins_witer.txt");
                //System.out.println("File created..");
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
                //JOptionPane.showMessageDialog(null,"Password matched");
            }else{
                //JOptionPane.showMessageDialog(null,"Worng Password");
            }
        }catch(FileNotFoundException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    boolean logic(String usr ,String pawd){
        try{
            RandomAccessFile raf =new RandomAccessFile(f+"/logins.txt","rw");
            for(int i=1;i<=in;i+=4){
                String forUser=raf.readLine().substring(9);
                String forPawd=raf.readLine().substring(9);
                if(usr.equals(forUser) && pawd.equals(forPawd)){
                    return true;
                    //JOptionPane.showMessageDialog(null,"Password matched");
                    //break;

                }else if(i==(in-4)){
                    //JOptionPane.showMessageDialog(null,"Worng Password");
                    //break;
                   return false;
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
        return false;
    }
    boolean logic1(String usr ,String pawd){
        try{
            RandomAccessFile raf =new RandomAccessFile(f1+"/logins_witer.txt","rw");
            for(int i=1;i<=in1;i+=4){
                String forUser=raf.readLine().substring(9);
                String forPawd=raf.readLine().substring(9);
                if(usr.equals(forUser) && pawd.equals(forPawd)){
                    return true;
                    //JOptionPane.showMessageDialog(null,"Password matched");
                    //break;

                }else if(i==(in1-4)){
                    //JOptionPane.showMessageDialog(null,"Worng Password");
                    //break;
                    return false;
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
        return false;
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
    void countLines1(){
        try{
            in1=1;
            RandomAccessFile raf = new RandomAccessFile(f1 + "/logins_witer.txt","rw");
            for(int i=0;raf.readLine()!=null;i++){
                in1++;
            }
        }catch(FileNotFoundException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        File showLockFile = new File("image/purple.jpg");
        Image showLockImage = new Image(showLockFile.toURI().toString());
        purple.setImage(showLockImage);

    }





    @FXML
    private void clickAction(ActionEvent event) throws IOException {


        if(event.getSource()==admin){
            createFolder();
            readFile();
            countLines();
            if(in==1){
                JOptionPane.showMessageDialog(null,"Worng Password");
            }
            else {
                usr = loginText.getText();
                pass = passText.getText();
                boolean b = logic(usr, pass);
                if (b) {
                    try {
                        FXMLLoader fxmlRegLoader = new FXMLLoader(getClass().getResource("Editor.fxml"));
                        Stage registrationStage = new Stage();
                        registrationStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene Regscene = new Scene(fxmlRegLoader.load());
                        // registrationStage.initStyle(StageStyle.UNDECORATED);
                        registrationStage.setScene(Regscene);
                        registrationStage.show();

                    } catch (Exception ex) {
                        ex.printStackTrace();
                        ex.getCause();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Worng Password");
                }
            }
        }
        if(event.getSource()==user) {
            createFolder();

            readFile1();
            countLines1();
            if (in1 == 1) {
                JOptionPane.showMessageDialog(null, "Worng Password");
            } else {
                usr = loginText.getText();
                pass = passText.getText();
                boolean b = logic1(usr, pass);
                if (b) {

                    try {
                        FXMLLoader fxmlRegLoader = new FXMLLoader(getClass().getResource("Writer.fxml"));
                        Stage registrationStage = new Stage();
                        registrationStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene Regscene = new Scene(fxmlRegLoader.load());
                        // registrationStage.initStyle(StageStyle.UNDECORATED);
                        registrationStage.setScene(Regscene);
                        registrationStage.show();

                    } catch (Exception ex) {
                        ex.printStackTrace();
                        ex.getCause();
                    }
                } else {

                    JOptionPane.showMessageDialog(null, "Worng Password");
                }
            }
        }

    }

    public void writerButtonOnAction(ActionEvent event) throws IOException{
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
    @FXML
    void gotoMagazine(MouseEvent event) {
        try{
            FXMLLoader fxmlRegLoader = new FXMLLoader(getClass().getResource("article_page.fxml"));
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

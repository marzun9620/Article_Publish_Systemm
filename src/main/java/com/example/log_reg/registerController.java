package com.example.log_reg;

//import com.example.log_reg.listControler;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TableView;

import static com.example.log_reg.listControler.Writers_info;


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
     ImageView showtopImageView;


    private Parent root;



    @Override
    public void initialize(URL location, ResourceBundle rb) {


        File showTopFile = new File("bg.jpg");
        Image showTopImage = new Image(showTopFile.toURI().toString());
        showtopImageView.setImage(showTopImage);

    }

    File f = new File("FileInfo");

    void createFolder(){
        if(!f.exists()){
            f.mkdirs();
        }
    }

    void readFile() {
        try {
            FileReader fr = new FileReader(f + "/logins_witer.txt");
            System.out.println("File Exits..");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f + "/logins_witer.txt");
                System.out.println("File created..");
            } catch (IOException ex1) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex1);

            }
        }
    }
    void countLines(){
        try{
            in=1;
            RandomAccessFile raf = new RandomAccessFile(f + "/logins_witer.txt","rw");
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
            RandomAccessFile raf = new RandomAccessFile(f+"/logins_witer.txt", "rw");
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






    public void userRegCancelOnAction(ActionEvent event){
        Stage stage = (Stage) userRegCancel.getScene().getWindow();
        stage.close();
    }

    public void userRegSignUpOnAction(ActionEvent event) throws IOException{
        createFolder();
        readFile();
        countLines();
        usr=userRegName.getText();
        pass=userRegPass.getText();
        emmail=userRegEmail.getText();
        //writers_info w=new writers_info(usr,emmail,pass);
           // table.getItems().add(w);
         //ObservableList<writers_info> Writers_info= FXCollections.observableArrayList(
              //  new writers_info(usr,emmail,pass)
        // );
        if(Writers_info==null) Writers_info=FXCollections.observableArrayList();
            writers_info temp = new writers_info(usr,emmail,pass);
            Writers_info.add(temp);


        addData(usr,pass,emmail);

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
}

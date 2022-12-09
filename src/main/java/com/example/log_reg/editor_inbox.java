package com.example.log_reg;

import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import com.example.log_reg.article_page;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class editor_inbox implements Initializable {
     int in;
    @FXML
    private Button composecancel;

    @FXML
    private Button composesendbutton;

    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;


    @FXML
    private ImageView writerarticleimage;
    File f = new File("FileInfo/writer.txt");


    public void Readtext(File f)throws IOException {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) !=null){
            textField1.setText(line);
        }
        br.close();
        fr.close();
    }
    void addData(String writing ){
        try{
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            for(int i=0;i<writing.length();i++){
                raf.readLine();
            }
            raf.writeBytes("\r\n");
            raf.writeBytes(writing+"\r\n");

            //raf.writeBytes("Email: "+mail);
        }catch(FileNotFoundException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void composeCancelClicked(MouseEvent event) throws IOException {
        Readtext(f);
    }

    @FXML
    void composeSendClicked(MouseEvent event) {
      String writing;
      writing=textField1.getText();
      addData(writing);
      //com.example.log_reg.article_page.SetText(writing);
      //writer_inbox.setText("Congrats Your Writing Got Published!!!!");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File showInboxFile = new File("bg.jpg");
        Image showInboxImage = new Image(showInboxFile.toURI().toString());
        writerarticleimage.setImage(showInboxImage);
    }
}

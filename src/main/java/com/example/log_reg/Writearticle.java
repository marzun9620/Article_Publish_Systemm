



package com.example.log_reg;

        import com.jfoenix.controls.JFXTextArea;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Button;
        import javafx.scene.control.TextArea;
        import javafx.scene.image.Image;
        import javafx.scene.image.ImageView;
        import javafx.scene.input.MouseEvent;

        import java.io.*;
        import java.net.URL;
        import java.util.ResourceBundle;
        import java.util.logging.Level;
        import java.util.logging.Logger;

public class Writearticle implements Initializable {
      int in;
    @FXML
    private Button composecancel;

    @FXML
    private Button composesendbutton;

    @FXML
    private TextArea text;

    @FXML
    private ImageView writerarticleimage;

    File f = new File("FileInfo");

    void createFolder(){
        if(!f.exists()){
            f.mkdirs();
        }
    }


    void readFile() {
        try {
            FileReader fr = new FileReader(f + "/writer.txt");
            //System.out.println("File Exits..");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f + "/writer.txt");
                //System.out.println("File created..");
            } catch (IOException ex1) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex1);

            }
        }
    }

    void addData(String writings ){
        try{
            RandomAccessFile raf = new RandomAccessFile(f+"/writer.txt", "rw");
            for(int i=0;i<in;i++){
                raf.readLine();
            }
            raf.writeBytes("\r\n");
            raf.writeBytes("Writings: "+writings+"\r\n");
            //raf.writeBytes("Email: "+mail);
        }catch(FileNotFoundException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    void countLines(){
        try{
            in=1;
            RandomAccessFile raf = new RandomAccessFile(f + "/writer.txt","rw");
            for(int i=0;raf.readLine()!=null;i++){
                in++;
            }
        }catch(FileNotFoundException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




    @FXML
    void composeCancelClicked(MouseEvent event) {

    }

    @FXML
    void composeSendClicked(MouseEvent event) {
         String writings;
         writings=text.getText();
         createFolder();
         readFile();
         countLines();
         addData(writings);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File showTopFile = new File("bg.jpg");
        Image showTopImage = new Image(showTopFile.toURI().toString());
        writerarticleimage.setImage(showTopImage);

    }
}


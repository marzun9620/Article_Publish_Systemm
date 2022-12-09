    package com.example.log_reg;

    import com.jfoenix.controls.JFXButton;
    import javafx.collections.FXCollections;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.fxml.Initializable;
    import javafx.geometry.Insets;
    import javafx.scene.Node;
    import javafx.scene.Scene;
    import javafx.scene.control.Label;
    import javafx.scene.control.TableColumn;
    import javafx.scene.control.TableView;
    import javafx.scene.control.cell.PropertyValueFactory;
    import javafx.scene.image.Image;
    import javafx.scene.image.ImageView;
    import com.example.log_reg.Controller;
    import javafx.scene.input.MouseEvent;
    import javafx.scene.layout.*;
    import javafx.scene.paint.Color;
    import javafx.stage.Stage;

    import java.io.File;
    import java.io.IOException;
    import java.net.URL;
    import java.util.ResourceBundle;

    public class EditorController implements Initializable {
        String usernamme,emmail,acction;

        @FXML
        private TableColumn<writers_info, String> action;
        @FXML
        private AnchorPane ap;

        @FXML
        private JFXButton addNew;
        @FXML
        private JFXButton profile1;
        @FXML
        private JFXButton logout1;
        @FXML
        private JFXButton compose1;
        @FXML
        private JFXButton writerlist1;





        @FXML
        private ImageView compose;

        @FXML
        private ImageView editor;



        @FXML
        private JFXButton exportMember;

        @FXML
        private JFXButton importMember;
        @FXML
        private Label label1;


        @FXML
        private ImageView logout;


        @FXML
        private ImageView profile;
        @FXML
        private HBox hbox1;



        @FXML
        private ImageView writerList;
       /* public void setData(String username , String email , String action ) {
           this.usernamme=username;
           this.emmail=email;
           this.acction=action;
        }
        ObservableList<writers_info> list = FXCollections.observableArrayList(
                new writers_info(usernamme,emmail,acction)
        );*/
        @Override
        public void initialize(URL location, ResourceBundle resources) {
            File showUserFile = new File("image/editor/profile.png");
            Image showUserImage = new Image(showUserFile.toURI().toString());
            profile.setImage(showUserImage);


            File showInboxFile = new File("image/editor/new-email.png");
            Image showInboxImage = new Image(showInboxFile.toURI().toString());
            compose.setImage(showInboxImage);



            File showWriter_listFile = new File("image/writer/icons8-users-96.png");
            Image showWriterImage = new Image(showWriter_listFile.toURI().toString());
            writerList.setImage(showWriterImage);



            File showLogoutFile = new File("image/editor/logout.png");
            Image showLogoutImage = new Image(showLogoutFile.toURI().toString());
            logout.setImage(showLogoutImage);


        }
        @FXML
        private void clickAction(ActionEvent event) throws IOException {

             if(event.getSource()==compose1){
                label1.setText("Compose");
                hbox1.setBackground(new Background(new BackgroundFill(Color.rgb(99,43,63), CornerRadii.EMPTY, Insets.EMPTY)));

            }
            else if(event.getSource()==logout1){
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
        @FXML
        public void profile(MouseEvent event) throws IOException {
            label1.setText("Editor Profile");
            Node node;
            node=(Node)FXMLLoader.load(getClass().getResource("editorprofile.fxml"));
            ap.getChildren().setAll(node);
        }
        @FXML
        void compose(MouseEvent event) throws IOException {
            Node node;
            node=(Node)FXMLLoader.load(getClass().getResource("editor_inbox.fxml"));
            ap.getChildren().setAll(node);
        }
        @FXML
        void writerlist(MouseEvent event) throws IOException {
            label1.setText("Writer List");
            hbox1.setBackground(new Background(new BackgroundFill(Color.rgb(43,99,63), CornerRadii.EMPTY, Insets.EMPTY)));
            Node node;
            node=(Node)FXMLLoader.load(getClass().getResource("writerlist.fxml"));
            ap.getChildren().setAll(node);

        }

    }

    package com.example.log_reg;

    import com.jfoenix.controls.JFXButton;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
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
    import javafx.scene.image.ImageView;
    import com.example.log_reg.Controller;
    import javafx.scene.layout.Background;
    import javafx.scene.layout.BackgroundFill;
    import javafx.scene.layout.CornerRadii;
    import javafx.scene.layout.HBox;
    import javafx.scene.paint.Color;
    import javafx.stage.Stage;

    import java.net.URL;
    import java.util.ResourceBundle;

    public class EditorController implements Initializable {
        String usernamme,emmail,acction;

        @FXML
        private TableColumn<writers_info, String> action;

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
        private TableColumn<writers_info, String> email;

        @FXML
        private JFXButton exportMember;

        @FXML
        private JFXButton importMember;
        @FXML
        private Label label1;


        @FXML
        private ImageView logout;

        @FXML
        private TableColumn<writers_info, String> name;

        @FXML
        private ImageView profile;
        @FXML
        private HBox hbox1;

        @FXML
        private TableView<writers_info> table;

        @FXML
        private ImageView writerList;
        public void setData(String username , String email , String action ) {
           this.usernamme=username;
           this.emmail=email;
           this.acction=action;
        }
        ObservableList<writers_info> list = FXCollections.observableArrayList(
                new writers_info(usernamme,emmail,acction)
        );
        @Override
        public void initialize(URL location, ResourceBundle resources) {
             name.setCellValueFactory(new PropertyValueFactory<writers_info , String>("name"));
             action.setCellValueFactory(new PropertyValueFactory<writers_info , String>("action"));
             email.setCellValueFactory(new PropertyValueFactory<writers_info , String>("email"));
             table.setItems(list);
        }
        @FXML
        private void clickAction(ActionEvent event){
            if(event.getSource()==profile1){
                label1.setText("Editor Profile");
                hbox1.setBackground(new Background(new BackgroundFill(Color.rgb(63,43,99), CornerRadii.EMPTY, Insets.EMPTY)));
            }
            else if(event.getSource()==compose1){
                label1.setText("Compose");
                hbox1.setBackground(new Background(new BackgroundFill(Color.rgb(99,43,63), CornerRadii.EMPTY, Insets.EMPTY)));

            }
            else if(event.getSource()==writerlist1){
                label1.setText("Writer List");
                hbox1.setBackground(new Background(new BackgroundFill(Color.rgb(43,99,63), CornerRadii.EMPTY, Insets.EMPTY)));

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
    }

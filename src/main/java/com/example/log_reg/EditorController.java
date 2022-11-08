    package com.example.log_reg;

    import com.jfoenix.controls.JFXButton;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.fxml.FXML;
    import javafx.fxml.Initializable;
    import javafx.scene.control.TableColumn;
    import javafx.scene.control.TableView;
    import javafx.scene.control.cell.PropertyValueFactory;
    import javafx.scene.image.ImageView;
    import com.example.log_reg.Controller;

    import java.net.URL;
    import java.util.ResourceBundle;

    public class EditorController implements Initializable {
        String usernamme,emmail,acction;

        @FXML
        private TableColumn<writers_info, String> action;

        @FXML
        private JFXButton addNew;

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
        private ImageView logout;

        @FXML
        private TableColumn<writers_info, String> name;

        @FXML
        private ImageView profile;

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
    }

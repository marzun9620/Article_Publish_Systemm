package com.example.log_reg;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class listControler implements Initializable {
    @FXML
    private TableView<writers_info> table;
    @FXML
    public TableColumn<writers_info, String> userName;

    @FXML
    public TableColumn<writers_info, String> userPass;
    @FXML
    public TableColumn<writers_info, String> email;
   // public static ObservableList<writers_info> Writers_info= FXCollections.observableArrayList(
         //   new writers_info("Marzun","emim9620@gmail.com","shamsun99"),
          //  new writers_info("Marzun","emim9620@gmail.com","shamsun99")
   // );
    public static ObservableList<writers_info> Writers_info;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userName.setCellValueFactory(new PropertyValueFactory<writers_info, String>("userName"));
        userPass.setCellValueFactory(new PropertyValueFactory<writers_info, String>("userPass"));
        email.setCellValueFactory(new PropertyValueFactory<writers_info, String>("email"));
        table.setItems(Writers_info);
    }
    //new writers_info("Marzun","emim9620@gmail.com","shamsun99");
}

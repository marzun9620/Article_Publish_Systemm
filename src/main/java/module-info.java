module com.example.log_reg {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.j;
    requires java.desktop;
    requires com.jfoenix;


    opens com.example.log_reg to javafx.fxml;
    exports com.example.log_reg;
}
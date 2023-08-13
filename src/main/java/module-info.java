module com.example.connectdb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.connectdb to javafx.fxml;
    exports com.example.connectdb;
}
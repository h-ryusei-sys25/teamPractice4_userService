module com.example.teampractice_userservice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.teampractice_userservice to javafx.fxml;
    exports com.example.teampractice_userservice;
}
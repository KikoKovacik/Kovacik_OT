module com.example.__animal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.__animal to javafx.fxml;
    exports com.example.__animal;
}
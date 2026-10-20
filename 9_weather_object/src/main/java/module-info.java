module com.example.__weather_object {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.__weather_object to javafx.fxml;
    exports com.example.__weather_object;
}
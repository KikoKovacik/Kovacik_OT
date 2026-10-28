module com.example._2_vlakna {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example._2_vlakna to javafx.fxml;
    exports com.example._2_vlakna;
}
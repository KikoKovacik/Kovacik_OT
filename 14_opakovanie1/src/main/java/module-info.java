module com.example._4_opakovanie1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example._4_opakovanie1 to javafx.fxml;
    exports com.example._4_opakovanie1;
}
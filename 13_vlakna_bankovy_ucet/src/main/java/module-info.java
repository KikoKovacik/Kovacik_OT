module com.example._3_vlakna_bankovy_ucet {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example._3_vlakna_bankovy_ucet to javafx.fxml;
    exports com.example._3_vlakna_bankovy_ucet;
}
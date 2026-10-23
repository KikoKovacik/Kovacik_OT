module com.example._1_nakupny_zoznam {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example._1_nakupny_zoznam to javafx.fxml;
    exports com.example._1_nakupny_zoznam;
}
package com.example._0_;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField textfield;
    @FXML private ListView<String> list;
    private ObservableList<String> zoznam = FXCollections.observableArrayList();

    @FXML private void initialize(){
        list.setItems(zoznam);
    }

    @FXML protected void nahodtext(){
        textfield.setText(list.getSelectionModel().getSelectedItem());
    }

    @FXML protected void pridanie(){
        String text = textfield.getText();
        if(text.isEmpty())return;
        else zoznam.add(text);
        textfield.clear();
    };
    @FXML protected void zmazanie(){
        int i = list.getSelectionModel().getSelectedIndex();
        if(i>=0) zoznam.remove(i);
        else return;
    };
    @FXML protected void editacia(){
        int i = list.getSelectionModel().getSelectedIndex();
        if(textfield.getText().isEmpty())return;
        else if(i>=0)zoznam.set(i, textfield.getText());
        else return;
        textfield.clear();
    };

}

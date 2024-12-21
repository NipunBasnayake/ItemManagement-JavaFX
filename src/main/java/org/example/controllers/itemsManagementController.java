package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class itemsManagementController {
    public void addItemOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/add_Items_Form.fxml"))));
        stage.setTitle("Add Item Form");
        stage.show();
    }

    public void viewItemsOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/view_Items_Form.fxml"))));
        stage.setTitle("View Item Form");
        stage.show();
    }

    public void deleteItemsOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/delete_Items_Form.fxml"))));
        stage.setTitle("Delete Item Form");
        stage.show();
    }
}

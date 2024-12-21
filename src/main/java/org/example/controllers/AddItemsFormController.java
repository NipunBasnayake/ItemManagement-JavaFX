package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.db.DBConnection;
import org.example.model.Item;

import java.net.URL;
import java.util.ResourceBundle;

public class AddItemsFormController implements Initializable {

    public Label lblItemId;
    public TextArea txtItemDescription;
    public TextField txtPrice;
    public TextField txtItemQuantity;
    public TextField txtItemName;

    private static int itemIdCount = 1;

    public void addItemToListOnAction(ActionEvent actionEvent) {

        if (txtItemName.getText().isEmpty() || txtItemQuantity.getText().isEmpty() || txtPrice.getText().isEmpty() || txtItemDescription.getText().isEmpty()){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Empty Fields");
            errorAlert.setHeaderText("Empty Fields");
            errorAlert.setContentText("Please fill all the required fields");
            errorAlert.showAndWait();
            return;
        }

        String item_id = String.valueOf(itemIdCount++);
        String item_name = txtItemName.getText();
        int item_qty = Integer.parseInt(txtItemQuantity.getText());
        String item_description = txtItemDescription.getText();
        Double item_price =Double.parseDouble(txtPrice.getText());

        Item newItem = new Item(item_id, item_name, item_qty, item_description, item_price);
        boolean isAdded = DBConnection.getInstance().getConnection().add(newItem);

        if (isAdded) {
            Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
            errorAlert.setTitle("item Added");
            errorAlert.setHeaderText("Item added successfully.");
            errorAlert.showAndWait();

            txtItemDescription.setText("");
            txtPrice.setText("");
            txtItemQuantity.setText("");
            txtItemName.setText("");

            updateNextItemId();
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Item Cant Added");
            errorAlert.setHeaderText("Failed to add item.");
            errorAlert.showAndWait();
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateNextItemId();
    }

    private void updateNextItemId() {
        itemIdCount = DBConnection.getInstance().getConnection().size() + 1;
        lblItemId.setText("ITM" + String.format("%04d", itemIdCount));
    }
}

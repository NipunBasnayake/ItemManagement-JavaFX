package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import db.DBConnection;
import model.Item;

import java.util.Optional;

public class DeleteItemsFormController {

    public TableView tblViewItems;
    public TableColumn colItemID;
    public TableColumn colItemName;
    public TableColumn colItemQty;
    public TableColumn colItemDesc;
    public TableColumn colItemPrice;

    public void btnLoadTableOnAction(ActionEvent actionEvent) {
        loadTable();
    }

    private void loadTable() {
        ObservableList<Item> itemsObservableList = FXCollections.observableArrayList();
        colItemID.setCellValueFactory(new PropertyValueFactory<>("item_id"));
        colItemName.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        colItemQty.setCellValueFactory(new PropertyValueFactory<>("item_qty"));
        colItemDesc.setCellValueFactory(new PropertyValueFactory<>("item_description"));
        colItemPrice.setCellValueFactory(new PropertyValueFactory<>("item_price"));
        DBConnection.getInstance().getConnection().forEach(item -> {
            itemsObservableList.add((Item) item);
        });

        tblViewItems.setItems(itemsObservableList);
    }

    public void btnDeleteItemOnAction(ActionEvent actionEvent) {
        Item selectedItem = (Item) tblViewItems.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Delete Confirmation");
            confirmationAlert.setHeaderText("Are you sure you want to delete?");
            confirmationAlert.setContentText(
                    "Item Id: "+selectedItem.getItem_id() + "\nItem: " + selectedItem.getItem_name() + "\nQuantity: " + selectedItem.getItem_qty() + "\nDescription: " + selectedItem.getItem_description() + "\nPrice: " + selectedItem.getItem_price()
            );

            Optional<ButtonType> result = confirmationAlert.showAndWait();

            if (result.isPresent() && result.get().equals(ButtonType.OK)) {
                DBConnection.getInstance().getConnection().remove(selectedItem);
                tblViewItems.getItems().remove(selectedItem);

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Item Deleted");
                successAlert.setHeaderText(null);
                successAlert.setContentText("The item has been successfully deleted.");
                successAlert.showAndWait();
            }
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("No Selection");
            errorAlert.setHeaderText("No Item Selected");
            errorAlert.setContentText("Please select an item to delete.");
            errorAlert.showAndWait();
        }
    }
}

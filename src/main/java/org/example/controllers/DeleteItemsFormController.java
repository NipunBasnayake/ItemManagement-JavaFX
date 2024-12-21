package org.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.db.DBConnection;
import org.example.model.Item;

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
            DBConnection.getInstance().getConnection().remove(selectedItem);
            tblViewItems.getItems().remove(selectedItem);
        }else{
            System.out.println("No selected item");
            loadTable();
        }
    }
}

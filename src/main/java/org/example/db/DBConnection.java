package org.example.db;

import org.example.model.Item;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static DBConnection instance;
    private List<Item> itemList;

    private DBConnection() {
        itemList = new ArrayList<>();
    }

    public static DBConnection getInstance() {
        return instance == null ? instance = new DBConnection() : instance;
    }

    public List getConnection() {
        return itemList;
    }
}

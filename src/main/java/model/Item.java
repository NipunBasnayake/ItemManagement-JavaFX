package model;

public class Item {
    private String item_id;
    private String item_name;
    private int item_qty;
    private String item_description;
    private Double item_price;

    public Item(String item_id, String item_name, int item_qty, String item_description, Double item_price) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_qty = item_qty;
        this.item_description = item_description;
        this.item_price = item_price;
    }

    public Item() {
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getItem_qty() {
        return item_qty;
    }

    public void setItem_qty(int item_qty) {
        this.item_qty = item_qty;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public Double getItem_price() {
        return item_price;
    }

    public void setItem_price(Double item_price) {
        this.item_price = item_price;
    }

    @Override
    public String toString() {
        return "item{" +
                "item_id='" + item_id + '\'' +
                ", item_name='" + item_name + '\'' +
                ", item_qty=" + item_qty +
                ", item_description='" + item_description + '\'' +
                ", item_price=" + item_price +
                '}';
    }
}

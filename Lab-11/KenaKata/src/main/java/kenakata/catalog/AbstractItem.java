package kenakata.catalog;
import kenakata.enums.ItemType;
import kenakata.settlement.Seller;

public abstract class AbstractItem implements Item {
    private String sku;
    private String title;
    private double unitPrice;
    private int stock;
    private Seller seller;
    private ItemType type;

    public AbstractItem(String sku, String title, double unitPrice, int stock, Seller seller, ItemType type) {
        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.seller = seller;
        this.type = type;
    }
}
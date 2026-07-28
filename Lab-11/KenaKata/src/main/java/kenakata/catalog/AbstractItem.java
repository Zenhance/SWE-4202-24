package kenakata.catalog;
import kenakata.enums.ItemType;
import kenakata.exceptions.InsufficientStockException;
import kenakata.settlement.Seller;

public abstract class AbstractItem implements Item {
    private String sku;
    private String title;
    private double unitPrice;
    private int stock;
    private Seller seller;
    private ItemType kind;
}
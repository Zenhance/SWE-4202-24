package kenakata.catalog;
import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable{
    private final String sku;
    private final String title;
    private final long unitPrice;
    private int stock;
    private final Seller seller;

    protected CatalogItem(String sku, String title, long unitPrice, int stock, Seller seller){
        if(sku == null || sku.isBlank()){
            throw new IllegalArgumentException("SKU must not be blank");
        }
    }
}

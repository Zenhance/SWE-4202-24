package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;
import kenakata.order.Chargeable;
import kenakata.settlement.Seller;

public class CatalogItem implements Chargeable{
    private final String sku;
    private final String title;
    private final long unitPrice;
    private int stock;
    private final Seller seller;

    public CatalogItem(String sku, String title, long unitPrice, int stock, Seller seller){
        if (sku == null || sku.isBlank() || title == null || title.isBlank() || seller == null){
            throw new IllegalArgumentException( );
        }
        if (unitPrice < 0 || stock < 0){
            throw new IllegalArgumentException( );
        }
        this.sku = sku;
        this.title = title;
        this.unitPrice = stock;
        this.seller = seller;
    }

}

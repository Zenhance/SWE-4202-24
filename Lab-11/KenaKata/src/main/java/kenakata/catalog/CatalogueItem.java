package kenakata.catalog;

public abstract class CatalogueItem implements OrderableLine{
    private final String sku;
    private final String title;
    private final double unitprice;
    private int LiveStockCount;
    private final Seller seller;


    protected CatalogueItem(String sku, String title, double unitprice,int LiveStockCount Seller seller) {
        this.sku = sku;
        this.title = title;
        this.unitprice = unitprice;
        this.seller = seller;
    }
}

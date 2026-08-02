package kenakata.catalog;

public abstract class CatalogueItem {
    protected int sku;
    protected String title;
    protected int unitPrice;
    protected int stockCount;


    public int getSku() {
        return sku;
    }

    public String getTitle() {
        return title;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getStockCount() {
        return stockCount;
    }

    public CatalogueItem(int sku, String title, int unitPrice, int stockCount){
        this.sku=sku;
        this.title=title;
        this.unitPrice=unitPrice;
        this.stockCount=stockCount;
    }


}

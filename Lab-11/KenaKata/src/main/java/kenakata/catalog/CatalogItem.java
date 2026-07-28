package catalog;

public abstract class CatalogItem implements Chargeable {
    private String sku;
    private String title;
    private double unitPrice;
    private int stockRemaining;
    private Seller seller;

    public CatalogItem(String sku, String title, double unitPrice, int stockRemaining, Seller seller) {
       if (sku == null || sku.isBlank()) {
           throw new IllegalArgumentException("sku cannot be null or blank");
       }
       if (title == null || title.isBlank()) {
           throw new IllegalArgumentException("title cannot be null or blank");
       }
       if (unitPrice < 0 ) {
           throw new IllegalArgumentException("unitPrice cannot be negative");
       }
       if(stockRemaining < 0){
           throw new IllegalArgumentException("stockRemaining cannot be negative");
       }
       if (seller == null) {
           throw new IllegalArgumentException("seller cannot be null");
       }
       this.sku = sku;
       this.title = title;
       this.unitPrice = unitPrice;
       this.stockRemaining = stockRemaining;
       this.seller = seller;
    }
}

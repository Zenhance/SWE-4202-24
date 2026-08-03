package catalog;

public abstract class CatalogItem implements Chargable{
    private final String sku;
    private final String title;
    private final long unitPrice;
    private int remaining;
    private final Seller seller;


    public CatalogItem(String sku, String title, long unitPrice, int remaining, Seller seller){
        if(sku==null || sku.isBlank() || title==null || title.isBlank()){
            throw new IllegalArgumentException("improperly informed item identification or seller");
        }

        if(unitPrice<0 || remaining<0){
            throw new IllegalArgumentException(("prices and remaining must be positive"));
        }

        this.sku = sku;
        this.title= title;
        this.unitPrice=unitPrice;
        this.remaining=remaining;
        this.seller=seller;
    }

    public String sku(){
        return sku;
    }

    public String title(){
        return title;
    }

}

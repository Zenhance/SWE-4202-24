package kenakata.catalog;

public abstract class CatalogItem implements Chargable{
    private String sku;
    private String title;
    private long unitPrice;
    private int stock;
    private Seller seller;

    public CatalogItem(String sku, String title, long unitPrice, int stock, Seller seller ){

        if(sku==null || sku.isBlank()){
            throw new IllegalArgumentException("Invalid SKU");
        }

        if(title==null || title.isBlank()){
            throw new IllegalArgumentException("Invalid title");
        }

        if(seller==null){
            throw new IllegalArgumentException("Seller cannot be null");
        }

        if(unitPrice<0){
            throw new IllegalArgumentException("Price cannot be negative");
        }

        if(stock<0){
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        this.sku=sku;
        this.title=title;
        this.unitPrice=unitPrice;
        this.stock=stock;
        this.seller=seller;
    }

    public String  getSku() {
        return sku;
    }

    public String getTitle() {
        return title;
    }
    public int remaining() {
        return stock;
    }

    public Seller getSeller() {
        return seller;
    }


    @Override
    public long unitCharge(){
        return unitPrice;  // Every catalogue item will implement their own unit charge. Thats why, we extended them.
    }

    public void reserve(int quantity) throws OutofStockException{
        if(quantity<=0){
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if(quantity>stock){
            throw  new OutOfStockException();
        }

        stock-=quantity;
    }

    @Override
    public abstract long unitVat();

    public abstract long commissionOn(long lineValue);


}

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
        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("Title must not be blank");
        }
        if(unitPrice<0){
            throw new IllegalArgumentException("Unit price cannot be negative");
        }
        if(stock<0){
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        if(seller == null){
            throw new IllegalArgumentException("Seller must not be null");
        }
        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.seller = seller;
    }
    public final String sku(){
        return sku;
    }
    public final String title(){
        return title;
    }
    public final long unitPrice(){
        return unitPrice;
    }
    public final Seller seller(){
        return seller;
    }
    public final int remaining(){
        return stock;
    }
    public final boolean canReserve(int quantity){
        validateQuantity(quantity);
        return stock>=quantity;
    }
    public final void reserve(int quantity) throws OutOfStockException{
            validateQuantity(quantity);
            if(stock<quantity){
                throw new OutOfStockException(title + " has only " + stock + " unit(s) remaining");
            }
            stock-=quantity;
        }
        public final void release(int quantity){
            validateQuantity(quantity);
            stock = Math.addExact(stock, quantity);
        }
        private static void validateQuantity(int quantity){
            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantity must be positive");
            }
        }
        @Override
                public final long unitCharge(){
            return unitPrice;
        }
        @Override
                public final String label(){
            return title;
        }
        public abstract long commissionOn(long lineValue);
}

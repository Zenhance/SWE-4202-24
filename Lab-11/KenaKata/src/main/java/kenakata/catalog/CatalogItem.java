package kenakata.catalog;
import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable {
    private final String sku;
    private final String title;
    private final long unitPrice;
    private int stock;
    private final Seller seller;

    protected CatalogItem(String sku, String title, long unitPrice, int stock, Seller seller) {
        if (sku == null || sku.trim().isEmpty() || title == null || title.trim().isEmpty() || seller == null) {
            throw new IllegalArgumentException("Invalid identity data");
        }
        if (unitPrice < 0 || stock < 0) {
            throw new IllegalArgumentException("Negative price or stock");
        }
        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.seller = seller;
    }

    public String sku() { return sku; }
    public String title() { return title; }
    public Seller seller() { return seller; }
    public int remaining() { return stock; }

    @Override public long unitCharge() { return unitPrice; }
    @Override public String label() { return title; }

    public void reserve(int quantity) throws OutOfStockException {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
        if (quantity > stock) throw new OutOfStockException("Insufficient stock for " + title);
        stock -= quantity;
    }

    public abstract long commissionOn(long totalCharge);
    public boolean isWeighable() { return false; }
    public int weight() { return 0; }
    public boolean isFresh() { return false; }
    public boolean isDiscountable() { return false; }
    public boolean isInsurable() { return false; }
    public boolean isReturnable() { return false; }
    public int returnWindowDays() { return 0; }






}

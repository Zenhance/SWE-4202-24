package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;


public abstract class CatalogItem implements Chargeable {

    private final String sku;
    private final String title;
    private final long unitPrice;
    private final Seller seller;
    private int stock;

    protected CatalogItem(String sku, String title, long unitPrice, int stock, Seller seller) {
        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException("sku must not be blank");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title must not be blank");
        }
        if (seller == null) {
            throw new IllegalArgumentException("seller must not be null");
        }
        if (unitPrice < 0) {
            throw new IllegalArgumentException("unitPrice must not be negative");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("stock must not be negative");
        }
        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.seller = seller;
    }

    public String sku() {
        return sku;
    }

    public String title() {
        return title;
    }

    public long unitPrice() {
        return unitPrice;
    }

    public Seller seller() {
        return seller;
    }

    public int remaining() {
        return stock;
    }

    /** Lowers stock by {@code quantity}, refusing when too few units remain. */
    public void reserve(int quantity) throws OutOfStockException {
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be positive");
        }
        if (quantity > stock) {
            throw new OutOfStockException(
                    "only " + stock + " of " + sku + " remain, cannot reserve " + quantity);
        }
        stock -= quantity;
    }

    @Override
    public long unitCharge() {
        return unitPrice;
    }

    @Override
    public String label() {
        return title;
    }


    public abstract long commissionOn(long lineValue);
}

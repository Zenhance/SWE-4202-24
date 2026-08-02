package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

/**
 * A listed item, of whatever kind. Every item -- stocked, digital, or fresh -- has a SKU, a
 * title, a unit price, a live stock count, and an owning seller, and can report those, report
 * how many remain, and reserve a quantity. That behaviour is identical for every kind and lives
 * here; each subclass only supplies how it takes part in the money (its VAT rate and its
 * commission rate) and which optional capabilities (weight, cold-chain, insurable, returnable)
 * it carries.
 *
 * <p>A malformed item -- null identity, negative price, negative stock -- must never come into
 * existence, so construction validates eagerly with an unchecked {@link IllegalArgumentException}.
 */
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

    /** The platform's commission on a line of this item's kind worth {@code lineValue} Taka. */
    public abstract long commissionOn(long lineValue);
}

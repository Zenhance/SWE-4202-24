package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

/**
 * Common parent
 */
public abstract class CatalogItem implements Chargeable {

    private final String sku;
    private final String title;
    private final long unitPrice;
    private final Seller seller;

    private int remaining;

    protected CatalogItem(
            String sku,
            String title,
            long unitPrice,
            int stock,
            Seller seller
    ) {
        if (sku == null || sku.isBlank()) {
            throw new IllegalArgumentException(
                    "SKU cannot be blank"
            );
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(
                    "Title cannot be blank"
            );
        }

        if (unitPrice < 0) {
            throw new IllegalArgumentException(
                    "Unit price cannot be negative"
            );
        }

        if (stock < 0) {
            throw new IllegalArgumentException(
                    "Stock cannot be negative"
            );
        }

        if (seller == null) {
            throw new IllegalArgumentException(
                    "Seller cannot be null"
            );
        }

        this.sku = sku;
        this.title = title;
        this.unitPrice = unitPrice;
        this.remaining = stock;
        this.seller = seller;
    }

    public final String sku() {
        return sku;
    }

    public final String title() {
        return title;
    }

    public final long unitPrice() {
        return unitPrice;
    }

    public final Seller seller() {
        return seller;
    }

    public final int remaining() {
        return remaining;
    }

    @Override
    public final long unitCharge() {
        return unitPrice;
    }

    @Override
    public final String label() {
        return title;
    }

    /**
     Checks stock.**/
    public final void ensureAvailable(int quantity)
            throws OutOfStockException {

        requirePositiveQuantity(quantity);

        if (quantity > remaining) {
            throw new OutOfStockException(
                    title + " has only " + remaining
                            + " unit(s), requested " + quantity
            );
        }
    }

    /**
      Reserves the entire quantity **/
    public final void reserve(int quantity)
            throws OutOfStockException {

        ensureAvailable(quantity);
        remaining -= quantity;
    }

    public abstract long commissionOn(long lineValue);

    protected static void requireLineValue(long lineValue) {
        if (lineValue < 0) {
            throw new IllegalArgumentException(
                    "Line value cannot be negative"
            );
        }
    }

    protected static void requirePositiveQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be positive"
            );
        }
    }
}
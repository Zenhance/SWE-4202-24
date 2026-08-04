package kenakata.item;

import kenakata.exception.OutOfStockException;
import kenakata.seller.Seller;
import kenakata.util.Validate;

public abstract class CatalogueItem {

    private final String sku;
    private final String title;
    private final long unitPrice;
    private final Seller seller;

    private int stock;

    protected CatalogueItem(
            String sku,
            String title,
            long unitPrice,
            int stock,
            Seller seller
    ) {
        this.sku = Validate.notBlank(
                sku,
                "SKU"
        );

        this.title = Validate.notBlank(
                title,
                "Title"
        );

        this.unitPrice = Validate.nonNegative(
                unitPrice,
                "Unit price"
        );

        this.stock = Validate.nonNegative(
                stock,
                "Stock"
        );

        this.seller = Validate.notNull(
                seller,
                "Seller"
        );
    }

    public String getSku() {
        return sku;
    }

    public String getSKU() {
        return sku;
    }

    public String sku() {
        return sku;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return title;
    }

    public String title() {
        return title;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public long getPrice() {
        return unitPrice;
    }

    public long getPerUnitCharge() {
        return unitPrice;
    }

    public Seller getSeller() {
        return seller;
    }

    public Seller getOwner() {
        return seller;
    }

    public int getStockRemaining() {
        return stock;
    }

    public int getStock() {
        return stock;
    }

    public int stockRemaining() {
        return stock;
    }

    public boolean hasStock(int quantity) {
        Validate.positive(
                quantity,
                "Quantity"
        );

        return stock >= quantity;
    }

    public void checkStock(int quantity)
            throws OutOfStockException {

        Validate.positive(
                quantity,
                "Quantity"
        );

        if (stock < quantity) {
            throw new OutOfStockException(
                    "Not enough stock for "
                            + title
                            + ". Available: "
                            + stock
                            + ", requested: "
                            + quantity
            );
        }
    }

    public void reserve(int quantity)
            throws OutOfStockException {

        checkStock(quantity);

        stock = Math.subtractExact(
                stock,
                quantity
        );
    }

    public void reserveStock(int quantity)
            throws OutOfStockException {

        reserve(quantity);
    }

    public void release(int quantity) {
        Validate.positive(
                quantity,
                "Release quantity"
        );

        stock = Math.addExact(
                stock,
                quantity
        );
    }

    public void releaseStock(int quantity) {
        release(quantity);
    }

    /*
     * Returns VAT for one unit of this item.
     *
     * StockedGood: ceil(unitPrice × 7.5%)
     * DigitalGood: ceil(unitPrice × 5%)
     * FreshGood: 0
     */
    public abstract long getVat();

    public long getPerUnitVat() {
        return getVat();
    }

    /*
     * Returns platform commission for the supplied
     * product-line charge.
     *
     * StockedGood: 8%
     * DigitalGood: 20%
     * FreshGood: 5%
     */
    public abstract long getCommission(long lineCharge);

    /*
     * Only stocked goods are discountable.
     */
    public abstract boolean isDiscountable();

    @Override
    public String toString() {
        return title
                + " [SKU="
                + sku
                + ", price="
                + unitPrice
                + ", stock="
                + stock
                + ", seller="
                + seller.getName()
                + "]";
    }
}
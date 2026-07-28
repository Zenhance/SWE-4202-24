package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable {
    private final String sku;
    private final String title;
    private final long price;
    private int stock;
    private final Seller seller;

    public CatalogItem(String sku, String title, long price, int stock, Seller seller) {
        if (sku == null || sku.isBlank() || title == null || title.isBlank() || seller == null || price < 0 || this.stock < 0) {
            throw new IllegalArgumentException();
        }
        this.sku = sku;
        this.title = title;
        this.price = price;
        this.seller = seller;
    }

    @Override
    public long unitCharge() {
        return price;
    }

    public String Sku() {
        return sku;
    }
    public String Title() {
        return title;
    }
    public Seller seller() {
        return seller;
    }
    public int remaining() {
        return stock;
    }
    public void reserve(int quantity) throws OutOfStockException {
        if (quantity <= 0) {
            throw new IllegalArgumentException();
        }
        if (quantity > stock) {
            throw new OutOfStockException("Not enough stock, sorry!!!");
        }
        stock -= quantity;
    }
    public long comissionOn(long amount) {
        return 0;
    }
    @Override
    public String label() {
        return title;
    }

    public abstract long commissionOn(long amount);

    public int weightGrams() {
        return 0;
    }

    public boolean isColdChain() {
        return false;
    }


    public boolean isInsurable() {
        return false;
    }


    public boolean isReturnable() {
        return false;
    }


    public int returnWindow() {
        return 0;
    }
}

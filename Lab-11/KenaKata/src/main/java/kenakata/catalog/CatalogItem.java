package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public abstract class CatalogItem implements Chargeable {

    String SKU, TITLE;
    int UnitePrize, StockCount;
    private final Seller seller;

    public CatalogItem(String SKU, String TITLE, int UnitPrize, int StockCount, Seller seller) {
        if (SKU == null || SKU.isBlank())
            throw new IllegalArgumentException();
        if (TITLE == null || TITLE.isBlank())
            throw new IllegalArgumentException();
        if (seller == null)
            throw new IllegalArgumentException();
        if (UnitPrize < 0)
            throw new IllegalArgumentException();
        if (StockCount < 0)
            throw new IllegalArgumentException();
        this.SKU = SKU;
        this.TITLE = TITLE;
        this.StockCount = StockCount;
        this.UnitePrize = UnitPrize;
        this.seller = seller;
    }


    public long unitCharge() {
        return UnitePrize;
    }

    public abstract int commissionOn(int i);

    public abstract long unitVat();

    public void reserve(int quantity) throws OutOfStockException{

        if (quantity <= 0)
            throw new IllegalArgumentException();

        if (quantity > StockCount)
            throw new OutOfStockException("out of stock");
        StockCount-=quantity;
    }


}





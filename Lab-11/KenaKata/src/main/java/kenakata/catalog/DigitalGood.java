package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;

public class DigitalGood extends CatalogItem implements Chargeable{

    public DigitalGood(String sku, String title, long unitPrice, int stock, Seller seller){
        super(sku, title, unitPrice, stock, seller);
    }




    @Override
    public long unitVat() {
        return (long) Math.ceil(unitPrice * 0.05) ;
    }
    @Override
    public long commissionOn(int amount) {
        return (long) (amount * 0.2);
    }
    @Override
    public long unitCharge() {
        return unitPrice;
    }
}

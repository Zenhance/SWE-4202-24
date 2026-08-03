package kenakata.catalog;

import kenakata.settlement.SellerPayOut;

public class DigitalGood extends CatalogueItem {
    private static final double comission_rate=0.2;
    private static final double vat=0.05;

    public DigitalGood(String sku, String title, long unitprice, int livestock, Seller seller ) {
        super(sku, title, unitprice, livestock, seller);

    }


    @Override
    public long unitVat() {
        return (long)Math.ceil(unitCharge()*vat);
    }

    @Override
    public long commissionOn(long amount) {
        return (long)Math.ceil(amount*comission_rate);
    }
}

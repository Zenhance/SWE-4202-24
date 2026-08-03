package kenakata.catalog;



public final class DigitalGood extends CatalogItem {

    private static final double VAT= 5.0/100.0;
    private static final double COMISSION= 20.0/100.0;

    public DigitalGood(String sku, String title, long unitPrice, int stock, Seller seller) {
        super(sku, title, unitPrice, stock, seller);
    }




    @Override
    public long commissionOn(long lineValue) {
        return (long) Math.ceil(lineValue*COMISSION);
    }

    @Override
    public long unitVat() {
        return (long) Math.ceil(unitCharge()*VAT/100.0);
    }
}

package kenakata.catalog;



/** A good delivered by download: no weight, never ships, lower VAT, highest commission,
 * cannot be returned or insured. */
public final class DigitalGood extends CatalogItem {

    private static final double VAT= 5.0;
    private static final double COMISSION= 20.0;

    public DigitalGood(String sku, String title, long unitPrice, int stock, Seller seller) {
        super(sku, title, unitPrice, seller, stock);
    }




    @Override
    public long commissionOn(long lineValue) {
        return (long) Math.ceil(lineValue*COMISSION);
    }

    @Override
    public double vatCharge() {
        return Math.ceil(unitCharge()*VAT);
    }
}

package kenakata.catalog;

public class DigitalGood extends CatalogItem {

    public DigitalGood(String sku, String name, long unitPrice, int stock, Seller seller) {
        super(sku, name, unitPrice, stock, seller);
    }

    @Override
    public long unitVat() {
                        
        return (long) Math.ceil(unitCharge() * 0.05);
    }

    @Override
    public long commissionOn(long lineValue) {
                                
        return (long) Math.ceil(lineValue * 0.20);
    }

    @Override
    public int returnWindow() {
        return 0;
    }

    @Override
    public boolean isReturnable() {
        return false;
    }

    @Override
    public boolean isInsurable() {
        return false;
    }
}
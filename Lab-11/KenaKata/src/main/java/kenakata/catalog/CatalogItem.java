package kenakata.catalog;


public abstract class CatalogItem implements Chargeable {

    protected CatalogItem(String sku, String title, long price, int stock, Seller seller){
    }

    @Override
    public long unitCharge() {
        return 0;
    }

    @Override
    public long unitVat() {
        return 0;
    }
    public long commissionOn(long lineValue){
        return 0;
    }
    public int remaining(){
        return 0;
    }
    public Seller seller(){
        return null;
    }
}

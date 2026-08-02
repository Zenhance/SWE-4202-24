package kenakata.catalog;

public abstract class CatalogItem implements Chargeable{

    public int unitCharge() {
        return 0;
    }

    public int commissionOn(int i) {
    return 0;}

    public int unitVat() {
    return 0;}

    public void reserve(int i) {

    }
}

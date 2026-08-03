package kenakata.catalog;

public class DigitalGood extends CatalogItem {
    public DigitalGood(String sku,String title,long price,int stock,Seller seller) {
        super(sku,title,price,stock,seller);
    }

    @Override
    public long unitVat() {
        return (price*5 + 99) / 100;
    }

    @Override
    public long commissionOn(long amount) {
        // Digital er commission 20%

        return (amount * 20 + 99) / 100; //digital er commission holo 20%.
    }

}
package kenakata.catalog;

public class StockedGood extends CatalogItem{
    int weight,stock;
    public StockedGood(String SKU, String title, int unitprice, int stock, Seller s1, int Weight) {
        super(SKU, title, unitprice, s1);
        this.weight = Weight;
        this.stock = stock;
    }



    public void reserve(int i) {
    }

    public int remaining() {
        return stock;
    }

    @Override
    public int unitVat() {
        return 0;
    }

    @Override
    public int unitCharge() {
        return 0;
    }

    @Override
    public int commissionOn(int i) {
        return 0;
    }
}

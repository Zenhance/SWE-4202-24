package kenakata.catalog;

public class FreshGood extends CatalogItem implements Weighable, Insurable, Returnable{

    public final int coldChain = 50;

    public FreshGood(String a, String itemType, int unitPrice, int amount, Seller s, int weight) {
        super(a, itemType, unitPrice, amount, s, weight);
    }

    public int unitVat() {
        return 0;
    }

    public int commissionOn(int i) {
        double x = Math.ceil(i*0.05);
        return (int) x;
    }

    @Override
    public int getWeight(){
        return weight;
    }

    @Override
    public void returnItem(){
        returned = true;
    }
}

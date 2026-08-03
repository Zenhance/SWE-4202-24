package kenakata.catalog;
import kenakata.order.Insurable;
import kenakata.order.Returnable;
import kenakata.order.Weighable;
import kenakata.settlement.Seller;
public class StockedGood extends CatalogItem implements Weighable,Insurable,Returnable{
    private final int weightGrams;

    public StockedGood(String sku, String title, long unitPrice, int stock, Seller seller, int weightGrams) {
        super(sku, title, unitPrice, stock, seller);
        if (weightGrams <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.weightGrams = weightGrams;
    }
}

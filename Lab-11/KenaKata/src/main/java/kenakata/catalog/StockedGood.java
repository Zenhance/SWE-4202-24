package kenakata.catalog;

public final class StockedGood extends CatalogItem implements Weighable, Insurable, Returnable, Discountable{
    private final int unitWeightGrams;
    private StockedGood(String sku, String title, long unitPrice, int stock, Seller seller, int unitWeightGrams){
        super(sku,title,unitPrice,stock,seller);
        if(unitWeightGrams<=0){
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.unitWeightGrams = unitWeightGrams;
    }
}

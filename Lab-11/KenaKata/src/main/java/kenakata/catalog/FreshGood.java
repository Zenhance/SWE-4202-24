package kenakata.catalog;

public final class FreshGood extends CatalogItem implements Weighable, ColdChain, Insurable, Returnable{
    private static final long COLD_CHAIN_FEE = 50;
    private final int unitWeightGrams;
    public FreshGood(String sku, String title, long unitPrice, int stock, Seller seller, int unitWeightGrams){
        super(sku,title,unitPrice,stock,seller);
        if(unitWeightGrams<=0){
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.unitWeightGrams = unitWeightGrams;
    }

}

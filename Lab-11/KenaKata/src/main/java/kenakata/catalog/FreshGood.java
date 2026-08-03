package kenakata.catalog;

public class FreshGood extends CatalogItem implements Weighable, Returnable, ColdChain
{
    private long weightGrams;

    public FreshGood(String sku, String title, long unitPrice, int stock, Seller seller, long weightGrams)
    {
        super(sku, title, unitPrice, stock, seller);
        if(weightGrams<=0)
            throw new IllegalArgumentException("Weight must be positive");
        this.weightGrams = weightGrams;
    }

    @Override
    public long weightGrams()
    {
        return weightGrams;
    }

    @Override
    public long unitVat()
    {
        return 0;
    }

    @Override
    public long commissionOn(long lineValue)
    {
        return 0;
    }

    @Override
    public int returnWindowDays()
    {
        return 7;
    }
}
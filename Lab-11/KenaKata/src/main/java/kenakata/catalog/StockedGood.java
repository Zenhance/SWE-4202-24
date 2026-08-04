package kenakata.catalog;

public class StockedGood extends CatalogItem implements Weighable, Returnable, Insurable, Discountable
{
    private long weightGrams;

    public StockedGood(String sku, String title, long unitPrice, int stock, Seller seller, long weightGrams)
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
        return (long)Math.ceil(weightGrams*0.075);
    }

    @Override
    public long commissionOn(long lineValue)
    {
        return (long)Math.ceil(lineValue*0.08);
    }

    @Override
    public int returnWindowDays()
    {
        return 7;
    }

    @Override
    public long insure(long quantity) {
        return unitCharge()*quantity;
    }
}
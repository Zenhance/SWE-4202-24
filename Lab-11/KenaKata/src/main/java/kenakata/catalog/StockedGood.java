package kenakata.catalog;


public class StockedGood extends CatalogItem implements Weighable, Returnable, Insurable, Discountable
{
    private double weightGrams;

    public StockedGood(String sku, String title, double unitPrice, int stockRemaining, Seller seller, double weightGrams)
    {
        super(sku, title, unitPrice, stockRemaining, seller);
        if(weightGrams<=0)
            throw new IllegalArgumentException("Weight must be positive");
        this.weightGrams = weightGrams;
    }

    @Override
    public double weightGrams()
    {
        return weightGrams;
    }

    @Override
    public double unitVat()
    {
        return 0.0;
    }

    @Override
    public double commissionOn(double lineValue)
    {
        return 0.0;
    }

    @Override
    public int returnWindowDays()
    {
        return 7;
    }
}
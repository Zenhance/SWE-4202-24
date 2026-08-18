package kenakata.catalog;

public class StockedGood extends CatalogItem implements Weighable, Insurable, Returnable, Discountable
{
    private static final long VAT_BASIS_POINTS = 75;
    private static final long COMMISSION_BASIS_POINTS = 80;
    private static final int RETURN_WINDOW_DAYS = 7;
    private final long weightGrams;

    public StockedGood(String sku, String title, long unitPrice, long stock, Seller seller, long weightGrams)
    {
        super(sku, title, unitPrice, stock, seller);
        if(weightGrams <= 0)
        {
            throw new IllegalArgumentException("weightGrams must be positive");
        }
        this.weightGrams = weightGrams;
    }

    @Override
    public long unitVat()
    {
        return Money.ceilPercent(unitPrice(), VAT_BASIS_POINTS);
    }

    @Override
    public long commissionOn(long lineValue)
    {
        return Money.ceilPercent(lineValue, COMMISSION_BASIS_POINTS);
    }

    @Override
    public long weightGrams()
    {
        return weightGrams;
    }

    @Override
    public int returnWindowDays()
    {
        return RETURN_WINDOW_DAYS;
    }
}
package kenakata.catalog;

public class DigitalGood extends CatalogItem
{
    public DigitalGood(String sku, String title, long unitPrice, int stockRemaining, Seller seller)
    {
        super(sku, title, unitPrice, stockRemaining, seller);
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
}
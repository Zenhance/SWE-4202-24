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
        return (long)Math.ceil(unitCharge()*0.05) ;
    }

    @Override
    public long commissionOn(long lineValue)
    {
        return (long)(lineValue*0.2);
    }
}
package kenakata.catalog;

public class GiftWrap implements Chargeable
{
    @Override
    public long unitCharge()
    {
        return 50;
    }

    @Override
    public long unitVat()
    {
        return 0;
    }

    @Override
    public String label()
    {
        return "Gift Wrapping";
    }
}
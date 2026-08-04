package kenakata.catalog;


public class WarrantyPlan implements Chargeable
{
    private CatalogItem catalogItem;
    public WarrantyPlan(CatalogItem catalogItem)
    {
        if(catalogItem==null)
            throw new IllegalArgumentException("Catalog Item can not be null");
        this.catalogItem = catalogItem;
    }
    @Override
    public long unitCharge()
    {
        return (long)Math.ceil(catalogItem.unitCharge()*0.01);
    }

    @Override
    public long unitVat()
    {
        return (long)Math.ceil(unitCharge()*0.15);
    }

    @Override
    public String label()
    {
        return catalogItem.title();
    }
}
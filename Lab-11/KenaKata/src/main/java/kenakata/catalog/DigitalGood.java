package kenakata.catalog;

public final class DigitalGood extends CatalogItem{
    public DigitalGood(String sku, String title, long unitPrice, int stock, Seller seller){
        super(sku,title,unitPrice,stock,seller);
    }
    @Override
    public long unitVat(){
        return MoneyMath.ceilPercent(unitPrice(),5);
    }
    @Override
    public long commissionOn(long lineValue){
        if(lineValue<0){
            throw new IllegalArgumentException("Line value cannot be negative");
        }
        return MoneyMath.ceilPercent(lineValue,20);
    }
}

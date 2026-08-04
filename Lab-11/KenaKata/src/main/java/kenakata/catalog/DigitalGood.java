package kenakata.catalog;

public class DigitalGood extends CatalogItem{
    public DigitalGood(int sku,String title,int unitPrice,int stockCount,Seller seller){
        super(sku,title,unitPrice,stockCount,seller);
    }
    public long unitVat(){
        return (long)Math.ceil(unitCharge());
    }

    @Override
    public boolean isDiscountable() {
        return false;
    }

    @Override
    public boolean isWeighable() {
        return false;
    }
    public int weightGrams(){
        return 0;
    }
    public boolean needsColdChain(){
        return false;
    }

    @Override
    public boolean isInsurable() {
        return false;
    }

    @Override
    public boolean isReturnable() {
        return false;
    }

    @Override
    public int returnWindowDays() {
        return 0;
    }

    @Override
    public long commissionOn(long lineValue) {
        return (long)Math.ceil(lineValue*0.20);
    }
}

package kenakata.catalog;


public class DigitalGood extends Item{

    public DigitalGood (String sku, String title, long unitPrice, int stock, Seller seller){
        super(sku, title, unitPrice, stock, seller);
    }

    @Override
    public long unitCharge() {
        return super.unitCharge();
    }

    public long unitVat(){
        return (long)Math.ceil(unitPrice*0.05);
    }

    public long commissionOn(long n){
        return (long)Math.ceil(n*0.2);
    }

}

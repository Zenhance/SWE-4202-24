package kenakata.catalog;


public class DigitalGood extends Item{

    public DigitalGood (String sku, String title, long unitPrice, int stock, Seller seller){
        super(sku, title, unitPrice, stock, seller);
    }

    @Override
    public long unitCharge() {
        return super.unitCharge();
    }

    @Override
    public String label() {
        return title();
    }

    public long unitVat(){
        return (long)Math.ceil(unitCharge()*0.05);
    }

    public long commissionOn(long n){
        return (long)Math.ceil(n*0.2);
    }

}

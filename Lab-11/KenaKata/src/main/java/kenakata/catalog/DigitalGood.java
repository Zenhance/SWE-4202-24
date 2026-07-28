package kenakata.catalog;

public class DigitalGood extends Good{
    public DigitalGood(String SKU, String title, double unitPrice, int stockCount, Seller seller) {
        super(SKU, title, unitPrice, stockCount, seller);
    }

    public int unitCharge(){
        return (int) Math.ceil(getUnitPrice());
    }
    public int unitVat(){
        return (int) Math.ceil(getUnitPrice()*0.05);
    }
    public int commissionOn(int something) {
        return (int) Math.ceil( something*0.2);
    }
}

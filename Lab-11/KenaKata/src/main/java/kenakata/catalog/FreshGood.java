package kenakata.catalog;

public class FreshGood extends Good{
    public FreshGood(String SKU, String title, double unitPrice, int stockCount, Seller seller) {
        super(SKU, title, unitPrice, stockCount, seller);
    }
    public int unitVat(){
        return (int) Math.ceil(getUnitPrice()*0.00);
    }
    public int commissionOn(int  something){
        return (int) Math.ceil(0.05* something);
    }
    public int reserve(){

    }
}

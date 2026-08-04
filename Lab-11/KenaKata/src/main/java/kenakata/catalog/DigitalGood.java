package kenakata.catalog;

public class DigitalGood extends CatalogItem{
    public DigitalGood(String sku, String title, double unitPrice, int stockRemaining, Seller seller) {
        super(sku, title, unitPrice, stockRemaining, seller);
    }

    public double unitVat(){
        return 0.0;
    }
    public double commisionOn(double lineValue){
        return 0.0;
    }
}

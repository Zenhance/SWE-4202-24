package kenakata.catalog;

public class  DigitalGood extends CatalogueItem {
    public DigitalGood(String sku,String title, long price,int stock, Seller seller ){
        super(sku,title,price,stock,seller);
    }
    // Digital goods cannot be insured
    public boolean insurable() {
        return false;
    }
    // Digital goods cannot be returned
    public boolean returnable(){
        return false;
    }
    // Digital goods have 5% VAT
    @Override
    public long vatPerUnit(){
        return(long)Math.ceil(unitPrice*0.05);
    }
    // Platform commission is 20%
    @Override
    public double commissionRate(){
        return 0.20;
    }
}

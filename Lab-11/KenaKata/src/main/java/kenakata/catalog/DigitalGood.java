package kenakata.catalog;

public class DigitalGood extends CatalogItem{
    private final int downloads;

    public DigitalGood(String sku,String name,int price,int downloads,Seller seller){
        super(sku,name,price,seller);
        if(downloads<0){
            throw new IllegalArgumentException();
        }
        this.downloads=downloads;
    }

    public int downloads(){
        return downloads;
    }

    public int unitVat(){
        return ceilPercent(unitCharge(),5);
    }

    public int commissionOn(int amount){
        return (int) Math.ceil(amount*20/100.0);
    }
}

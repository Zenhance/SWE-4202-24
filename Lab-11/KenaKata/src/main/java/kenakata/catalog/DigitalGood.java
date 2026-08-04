package kenakata.catalog;

public  class DigitalGood extends CatalogItem{
    public DigitalGood(String sku,String name, long unitPrice,int stock,Seller seller){
        super(sku,name,unitPrice,stock, seller);
    }

    public long  unitVat() {
        return (long) Math.ceil(unitCharge() * 0.05);


    }
    public long  commissionOn(long i) {
        return (long) Math.ceil(i * 0.2);}}

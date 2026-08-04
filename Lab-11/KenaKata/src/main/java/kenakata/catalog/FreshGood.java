package kenakata.catalog;


public  class FreshGood extends CatalogItem{
    public FreshGood(String sku,String name, long unitPrice,int stock,Seller seller){
        super(sku,name,unitPrice,stock, seller);
    }

    public long  unitVat() {
        return 0;


    }
    public long  commissionOn(long i) {
        return (long) Math.ceil(i * 0.05);}}




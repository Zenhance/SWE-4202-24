package kenakata.catalog;

import kenakata.exceptions.OutOfStockException;


public abstract class CatalogItem implements Chargeable {
    private final String sku;
    private final String title;
    private final long unitprice;
    private int livestock;
    private final Seller seller;


    public CatalogItem(String sku, String title, long unitprice, int livestock, Seller seller) {
        if(sku==null || sku.isBlank() || title==null || title.isBlank() || seller==null){
            throw new IllegalArgumentException("MEOWWWWWWW");
        }
        if(unitprice<0 || livestock<0){
            throw new IllegalArgumentException("MEOWWWWWWW");
        }

        this.sku = sku;
        this.title = title;
        this.unitprice = unitprice;
        this.seller = seller;
        this.livestock=livestock;

    }
    public String getSku(){
        return sku;
    }
    public String getTitle(){
        return title;
    }

    public long getUnitprice() {
        return this.unitprice;
    }

    public int getLivestock() {
        return this.livestock;
    }

    public Seller getSeller() {
        return this.seller;
    }
    public int remaining(){
        return livestock;
    }
    public void reserve(int qty)throws OutOfStockException {
            if(qty<=0){
                throw new IllegalArgumentException("Invalid quantity is given");
            }
            if(qty>livestock){
                throw new OutOfStockException("Not enough amount is available");
            }
            livestock=livestock-qty;
    }

    @Override
    public String label(){
        return title;
    }
    @Override
    public long unitCharge(){
        return unitprice;
    }

    @Override
    public abstract long unitVat() ;
    public abstract long commissionOn(long amount);
}

package kenakata.catalog;

public abstract class CatalogItem implements Chargeable{
    private final String sku;
    private final String name;
    private final int price;
    private final Seller seller;

    public CatalogItem(String sku,String name,int price,Seller seller){
        if(sku==null || sku.isBlank()){
            throw new IllegalArgumentException();
        }
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException();
        }
        if(seller==null){
            throw new IllegalArgumentException();
        }
        if(price<0){
            throw new IllegalArgumentException();
        }
        this.sku=sku;
        this.name=name;
        this.price=price;
        this.seller=seller;
    }

    public String sku(){
        return sku;
    }
    public String name(){
        return name;
    }
    public Seller seller(){
        return seller;
    }

    public String label(){
        return name;
    }

    public int unitCharge(){
        return price;
    }

    protected int ceilPercent(int value,double percent){
        return (int)Math.ceil(value*percent/100.0);
    }

    public abstract int commissionOn(int amount);
}

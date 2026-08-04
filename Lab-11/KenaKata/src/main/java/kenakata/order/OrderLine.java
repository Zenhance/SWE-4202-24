package kenakata.order;


import kenakata.catalog.CatalogItem;
import kenakata.catalog.Chargeable;

public class OrderLine {
    private final Chargeable item;
    private final int quantity;
    private boolean insured;
    private boolean returned;


    public OrderLine(Chargeable item, int quantity) {
        if(item==null)
            throw new IllegalArgumentException("Invalid");
        if(quantity<=0)
            throw new IllegalArgumentException("Invalid");
        this.item = item;
        this.quantity = quantity;
    }
    public Chargeable getItem(){
        return item;
    }
    public int getQuantity(){
        return quantity;
    }

    public boolean isInsured() {
        return this.insured;
    }

    public void insure() {
        insured = true;
    }
    public boolean returned() {
        return returned;
    }

     public void markreturned(){
        returned=true;
     }


    public long vat(){
        return item.unitVat()*quantity;
    }


   public  long Charge(){
        return  item.unitCharge()*quantity;
   }
   public boolean isproduct(){
        return item instanceof CatalogItem;
   }
   public CatalogItem product(){
        return (CatalogItem) item;
   }

}

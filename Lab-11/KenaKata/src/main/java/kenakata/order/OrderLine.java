package kenakata.order;


import kenakata.catalog.CatalogueItem;
import kenakata.catalog.OrderableLine;

public class OrderLine {
    private final OrderableLine item;
    private final int quantity;
    private boolean insured;
    private boolean returned;


    public OrderLine(OrderableLine item, int quantity) {
        if(item==null)
            throw new IllegalArgumentException("Invalid");
        if(quantity<=0)
            throw new IllegalArgumentException("Invalid");
        this.item = item;
        this.quantity = quantity;
    }
    public OrderableLine getItem(){
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
        return item instanceof CatalogueItem;
   }
   public CatalogueItem product(){
        return (CatalogueItem) item;
   }

}

package kenakata.line;
import kenakata.item.CatalogueItem;
public class ProductLine implements OrderLine{
    private final CatalogueItem item;
    private final int quantity;
    private boolean returned;

    public ProductLine(CatalogueItem item,int quantity){
        this.item=item;
        this.quantity=quantity;
        this.returned=false;
    }
    public CatalogueItem getItem(){
        return item;
    }

    public int getQuantity(){
        return quantity;
    }
    public boolean isReturned(){
        return returned;
    }
    public void markReturned(){
        returned=true;
    }
    @Override
    public int getCharge(){
        return item.getPrice()*quantity;
    }
    @Override
    public int getVat(){
        return item.getVat()*quantity;
    }
    @Override
    public String gettRecieptLabel(){
        return item.getName();
    }
    public boolean isDiscountable(){
        return item.isDiscountable();
    }
}

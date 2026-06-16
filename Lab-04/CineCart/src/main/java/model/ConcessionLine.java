package model;

public class ConcessionLine {
    private ConcessionItem item;
    private int qty;
    public ConcessionLine(ConcessionItem item,int qty){
        this.item=item;
        this.qty=qty;
    }
    public double subtotal(){
        return item.getUnitPrice()*qty;
    }
    public String describe() {
    return item.getName()+"*"+qty;
    }
    public boolean hasCode(String code){
        return item.getCode().equals(code);
    }
}

package model;

public class ConcessionLine extends LineItem{
    private ConcessionItem item;
    private int qty;
    public ConcessionLine(ConcessionItem item, int qty) {
        this.item = item;
        this.qty = qty;
    }

    public double subtotal(){
        return item.unitPrice *qty;
    }

   public String describe(){
        return qty + "x " + item.getName();
    }

    public boolean hasCode(String code)
    {
        return item.getCode().equals(code);
    }


}

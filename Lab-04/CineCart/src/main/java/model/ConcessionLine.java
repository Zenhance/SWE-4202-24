package model;

import java.util.Objects;

public class ConcessionLine extends LineItem{
    private ConcessionItem item;
    private final int qty;
    public ConcessionLine(ConcessionItem item, int qty) {
        this.item = item;
        this.qty = qty;
    }

    @Override
    public double subtotal() {
        return item.getUnitPrice()*qty;
    }

    @Override
    public String describe(){
        return "Concession Line";
    }

    @Override
    public boolean hasCode(String code){
        return item.getCode().equals(code);
    }
}

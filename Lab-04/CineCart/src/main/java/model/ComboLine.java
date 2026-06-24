package model;

public class ComboLine extends LineItem {
    private ConcessionItem A;
    private ConcessionItem B;

    public ComboLine(ConcessionItem A, ConcessionItem B){
        this.A = A;
        this.B = B;
    }

    @Override
    public double subtotal(){
        return A.getUnitPrice()+B.getUnitPrice();
    }

    @Override
    public String describe(){
        return "comboline";
    }
}

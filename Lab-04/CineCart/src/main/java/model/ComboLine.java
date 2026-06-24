package model;

public class ComboLine extends LineItem {
    private ConcessionItem A;
    private ConcessionItem B;

    public ComboLine(ConcessionItem A, ConcessionItem B){
        this.A = A;
        this.B = B;
    }


    public ConcessionItem getA() {
        return A;
    }

    public ConcessionItem getB() {
        return B;
    }

    @Override
    public double subtotal(){
        return A.getUnitPrice()+B.getUnitPrice()-50;
    }

    @Override
    public String describe(){
        return "comboline";
    }

    @Override
    public boolean isTicket(){
        return false;
    }
}

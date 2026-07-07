package model;

public class ComboLine extends LineItem{
private ConcessionItem first;
private ConcessionItem second;

public ComboLine(ConcessionItem first,ConcessionItem second){
    this.first=first;
    this.second=second;
}
    @Override
    public double subtotal() {
        return first.getUnitPrice()+second.getUnitPrice()-50.00;
    }

    @Override
    public String describe() {
        return first.getName()+" + "+second.getName()+" Combo";
    }

    @Override
    public boolean hasCoode(String code) {
        return first.getCode().equals(code) || second.getCode().equals(code);
    }
}

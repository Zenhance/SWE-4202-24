package model;

public class ComboLine extends LineItem{
    private static final double COMBO_DISCOUNT = 50.00;

    private final ConcessionItem item1;
    private final ConcessionItem item2;

    public ComboLine(ConcessionItem item1, ConcessionItem item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public double subtotal() {
        return (item1.getUnitPrice() + item2.getUnitPrice()) - COMBO_DISCOUNT;
    }


    public String describe() {
        return item1.getName() + " + " + item2.getName()
                + " combo - BDT " + String.format("%.2f", subtotal());
    }


    public boolean hasCode(String code) {
        return item1.getCode().equals(code) || item2.getCode().equals(code);
    }
}

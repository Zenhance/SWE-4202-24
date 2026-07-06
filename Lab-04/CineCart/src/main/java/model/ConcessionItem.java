package model;

public class ConcessionItem extends LineItem{
    private final String code;
    private final String name;
    private final double unitPrice;

    public ConcessionItem(String code, String name, double unitPrice) {
        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String toString(){
        String out = String.format("%s - %s - BDT %.2f", code, name, unitPrice);
        return out;
    }

}

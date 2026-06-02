package model;

public class ConcessionItem {
    String code;
    String name;
    Double unitPrice;
    public ConcessionItem(String code, String name, Double unitPrice) {
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

    public Double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (Large) - BDT %.2f",code,name,unitPrice);
    }
}

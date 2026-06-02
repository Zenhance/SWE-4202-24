package model;

public class ConcessionItem {
    public String code;
    public String name;
    public double unitPrice;


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
        final String result =String.format("%s - %s - BDT %0.2f", code, name, unitPrice);
        return result;
    }
}

package model;

// ConcessionItem represents one snack or drink available at the counter.
// Examples: popcorn, soda, nachos.
public class ConcessionItem {

    // --- Fields ---
    private String code;
    private String name;       /
    private double unitPrice;

    // --- Constructor ---
    public ConcessionItem(String code, String name, double unitPrice) {
        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    // --- Getters ---
    public String getCode()         { return code; }
    public String getName()         { return name; }
    public double getUnitPrice()    { return unitPrice; }


    @Override
    public String toString() {
        return code + " - " + name + " - BDT " + String.format("%.2f", unitPrice);
    }
}

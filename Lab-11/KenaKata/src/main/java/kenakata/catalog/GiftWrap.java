package kenakata.catalog;

public class GiftWrap implements Chargeable {

    static final int unitPrice = 50;

    public int unitVat(){
        double x = Math.ceil(unitPrice*0.075);
        return (int) x;
    }

    public int unitCharge(){
        return unitPrice;
    }

    public String label() {
        return "Gift wrapping";
    }
}

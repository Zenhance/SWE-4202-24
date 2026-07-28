package kenakata.catalog;

public class ExpressHandling implements Chargeable {

    static final int unitPrice = 120;

    public int unitVat(){
        double x = Math.ceil(unitPrice*0.075);
        return (int) x;
    }

    public int unitCharge(){
        return unitPrice;
    }
}

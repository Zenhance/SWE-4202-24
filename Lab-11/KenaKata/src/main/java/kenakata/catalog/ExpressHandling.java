package kenakata.catalog;

public class ExpressHandling implements Chargeable {
    private final int unitPrice = 120;

    public double unitVat() {
        return (int) Math.ceil(unitPrice * 0.075);
    }


    public double unitCharge() {
        return unitPrice;
    }



    public int commissionOn(int total) {
        return (int) Math.ceil(total*0.00);
    }
}



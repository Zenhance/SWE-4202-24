package kenakata.catalog;

public class ExpressHandling extends AddOn {
    private final int unitPrice = 120;

    public double unitVat() {
        return (int) Math.ceil(unitPrice * 0.075);
    }

}

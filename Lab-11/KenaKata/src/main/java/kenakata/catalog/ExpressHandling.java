package kenakata.catalog;

public class ExpressHandling {
    private final int unitPrice = 120;


    public int unitVat() {
        return (int) Math.ceil(unitPrice*0.075);
    }
}

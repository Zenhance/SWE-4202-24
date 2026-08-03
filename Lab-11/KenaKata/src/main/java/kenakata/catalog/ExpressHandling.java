package kenakata.catalog;

public class ExpressHandling extends Product{
    public ExpressHandling() {
        super(120);
    }

    @Override
    public long unitVat() {
        return (long) Math.ceil(unitPrice()*0.075);
    }
}

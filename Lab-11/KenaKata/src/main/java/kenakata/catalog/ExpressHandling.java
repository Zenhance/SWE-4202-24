package kenakata.catalog;

public class ExpressHandling implements Chargeable{
    @Override
    public long unitCharge(){
        return 120;
    }
    @Override
    public long unitVat(){
        return (long)Math.ceil(120 * 7.5 / 100);
    }
    @Override
    public String label() {
        return "Express handling";
    }
}

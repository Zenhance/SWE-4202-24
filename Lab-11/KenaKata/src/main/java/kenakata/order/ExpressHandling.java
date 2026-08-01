package kenakata.order;

public class ExpressHandling implements Chargeable{
    @Override
    public long unitCharge(){
        return 120;
    }
    @Override
    public long unitVat(){
        return (long)Math.ceil(120*0.075);
    }
    @Override
    public String label(){
        return "Express Handling";
    }
}

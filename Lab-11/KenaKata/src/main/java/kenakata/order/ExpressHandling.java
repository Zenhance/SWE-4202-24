package kenakata.order;

public class ExpressHandling implements Chargeable{ //dispatch charge
    @Override
    public double unitCharge(){
        return 120; // cost per order
    }
    @Override
    public long unitVat(){

        return (long)Math.ceil(120*0.075);//7.5% vat on 120 tk
    }
    @Override
    public String label(){

        return "Express Handling"; //human-readable display
    }
}

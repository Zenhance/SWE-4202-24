package kenakata.catalog;

public class ExpressHandling implements Chargeable{
    public String label(){
        return "Express handling";
    }

    public int unitCharge(){
        return 120;
    }

    public int unitVat(){
        return (int) Math.ceil(120*7.5/100.0);
    }
}

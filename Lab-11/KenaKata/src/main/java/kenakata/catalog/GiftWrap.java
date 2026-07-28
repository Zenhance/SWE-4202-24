package kenakata.catalog;

public class GiftWrap implements Chargeable{
    public String label(){
        return "Gift wrapping";
    }

    public int unitCharge(){
        return 50;
    }

    public int unitVat(){
        return (int) Math.ceil(50*7.5/100.0);
    }
}

package kenakata.catalog;

public class ColdChain implements Chargeable{
    public String label(){
        return "Cold-Chain Delivery";
    }

    public int unitCharge(){
        return 50;
    }

    public int unitVat(){
        return 0;
    }
}

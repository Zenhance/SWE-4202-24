package kenakata.addon;
import kenakata.money.Money;

public class ExpressHandling implements chargeable {
    private static final long CHARGE = 120;
    private static final long VAT_PERMILLE = 75;


    public long unitCharge(){
        return CHARGE;
    }




    public long unitVat(){
        return Money.ceilPerMl(CHARGE, VAT_PERMILLE);
    }

    public String label(){
        return "Express handling";
    }
}

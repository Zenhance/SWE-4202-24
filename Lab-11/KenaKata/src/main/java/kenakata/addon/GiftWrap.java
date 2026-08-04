package kenakata.addon;

import kenakata.money.Money;
public class GiftWrap implements chargeable{
    private static final long CHARGE=50;
    private static final long VAT_PERMILLE=75;

    public long unitCharge() {
        return CHARGE;
    }




    @Override
    public long unitVat() {
        return Money.ceilPerMl(CHARGE, VAT_PERMILLE);
    }
    @Override
    public String label() {
        return "Gift wrapping";
    }


    public long unitPrice() {
        return 0;
    }
}

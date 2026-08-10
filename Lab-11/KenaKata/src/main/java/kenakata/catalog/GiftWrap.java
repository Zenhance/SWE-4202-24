package kenakata.catalog;

public class GiftWrap implements Chargeable{


    @Override
    public long unitVat() {
        return 4;
    }

    @Override
    public long unitCharge() {
        return 50;
    }



    @Override
    public String label() {
        return "Gift wrapping";
    }


}

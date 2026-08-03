package kenakata.catalog;

public class GiftWrap extends AddOn{
    public String label() {
    return "Gift Wraping";}
    public long unitCharge(){
        return 50;
    }

    @Override
    public long unitVat() {
        return 0;
    }
}

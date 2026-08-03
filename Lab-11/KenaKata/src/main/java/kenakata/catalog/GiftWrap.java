package kenakata.catalog;

public class GiftWrap extends Product{

    public GiftWrap() {
        super(50);
    }

    public String label() {
        return "Gift wrapping";
    }

    @Override
    public long unitVat() {
        return 0;
    }
}

package kenakata.addon;

public class GiftWrapping implements AddOn {

    private static final long CHARGE = 50;

    @Override
    public long getCharge() {
        return CHARGE;
    }

    @Override
    public long getVat() {
        return 4;
    }

    @Override
    public String getReceiptLabel() {
        return "Gift wrapping";
    }
}

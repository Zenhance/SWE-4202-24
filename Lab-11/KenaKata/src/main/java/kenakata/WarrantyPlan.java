package kenakata;

import java.nio.charset.Charset;

public class WarrantyPlan {
    public WarrantyPlan(StockedGood lamp) {
    }

    public int unitCharge() {
        return 120;
    }

    public int unitVat() {
        return 18;
    }

    public Charset label() {
        return null;
    }
}

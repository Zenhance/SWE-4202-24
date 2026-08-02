package kenakata.catalog;

import static java.lang.Math.ceil;

public class ExpressHandling implements Chargeable {

    public int unitCharge() {
        return 120;
    }

    @Override
    public int unitVat() {return (int) ceil(this.unitCharge()*0.075)}

}

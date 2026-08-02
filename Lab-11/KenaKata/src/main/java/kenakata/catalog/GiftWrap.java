package kenakata.catalog;

import static java.lang.Math.ceil;

public class GiftWrap implements Chargeable {
    public int unitCharge() {
        return 50;}
    public int unitVat() {return (int) ceil(this.unitCharge()*0.075);}
    public String label() {
        return  "Gift wrapping";
    }
}

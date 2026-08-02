package kenakata.catalog;

import java.nio.charset.Charset;

import static java.lang.Math.ceil;

public class WarrantyPlan implements Chargeable{
    StockedGood item;
    public WarrantyPlan(StockedGood item)
    {
        if(item==null) throw new IllegalArgumentException();
        this.item=item;
    }

    public int unitCharge() {
        return (int)ceil(item.unitCharge()*0.1);
    }

    public int unitVat() {
        return (int)ceil(this.unitCharge()*0.15);
    }

    public String label() {
        return  item.title;
    }
}

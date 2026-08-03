package kenakata.order;

import kenakata.catalog.*;
import java.util.*;

public class PriceBreakdown {
    private ArrayList<Chargeable> chargeables;
    private Coupon coupon;
    private Zone zone;

    public PriceBreakdown(ArrayList<Chargeable> chargeables, Zone zone){
        if(chargeables == null){
            throw new IllegalArgumentException("ArrayList of chargeables cannot be null");
    }
        this.chargeables = chargeables;

        if(zone == null){
            throw new IllegalArgumentException("Delivery zone cannot be null.");
    }
        this.zone = zone;
    }

}

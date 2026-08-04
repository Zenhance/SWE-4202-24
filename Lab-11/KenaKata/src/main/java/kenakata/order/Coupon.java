package kenakata.order;

import kenakata.catalog.*;
import kenakata.exceptions.*;
import kenakata.payment.*;

import java.util.*;

public class Coupon {
    final String code;
    final int percent;
    final int expiryDay;
    final long minSpend;
    final long cap;

    public Coupon(String code, int percent, int expiryDay, long minSpend, long cap) {
        if (percent < 0 || percent > 100) throw new IllegalArgumentException("Invalid percent");
        this.code = code;
        this.percent = percent;
        this.expiryDay = expiryDay;
        this.minSpend = minSpend;
        this.cap = cap;
    }

    public long computeDiscount(List<OrderLine> lines) {
        long base = 0;
        for (OrderLine line : lines) {
            if (line.item instanceof StockedGood) base += line.item.unitCharge() * line.qty;
        }
        long raw = (long)Math.ceil(base * percent / 100.0);
        return Math.min(raw, cap);
    }
}




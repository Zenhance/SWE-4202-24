package kenakata.order;

import kenakata.exceptions.CouponRejectedException;

public class Coupon {
    private final String code;
    private final double discount;
    private final double cap;
    private final int exp;
    private final double minSpend;

    public Coupon(String code, double discount, double cap, int exp, double minSpend) {
        this.code = code;
        this.discount = discount;
        this.cap = cap;
        this.exp = exp;
        this.minSpend = minSpend;
    }

    public String getCode() {
        return code;
    }

    public double getDiscount() {
        return discount;
    }

    public double getCap() {
        return cap;
    }

    public int getExp() {
        return exp;
    }

    public double getMinSpend() {
        return minSpend;
    }
    public double CalculateDis(double base, int today) throws CouponRejectedException {
        if(base<minSpend){
            throw new CouponRejectedException("You need to add more product to use this coupon " + code);
        }

        if(today>exp){
            throw new CouponRejectedException("This coupon - " + code+" has been expired");
        }
        double substractedPrice = base*(discount/100);
        if(substractedPrice>cap){
            substractedPrice = cap;
            return substractedPrice;
        }
        else {
            return substractedPrice;
        }

    }
}

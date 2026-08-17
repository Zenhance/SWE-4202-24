package kenakata.order;

import kenakata.exceptions.CouponRejectedException;

public class Coupon
{
    private String code;
    private long percentage;
    private long cap;
    private long minimumSpend;
    private int lastValidDays;

    public Coupon(String code, long percentage, long cap, long minimumSpend, int lastValidDays)
    {
        if (code == null)
            throw new IllegalArgumentException("Coupon code cannot be null");
        if (code.isBlank())
            throw new IllegalArgumentException("Coupon code cannot be blank");
        this.code = code;
        if (percentage <= 0)
            throw new IllegalArgumentException("Discount percentage cannot be negative or equal to zero");
        if (percentage > 100)
            throw new IllegalArgumentException("Discount percentage cannot be greater than 100");
        this.percentage = percentage;
        if (cap <= 0)
            throw new IllegalArgumentException("Cap cannot be negative or zero");
        this.cap = cap;
        if (minimumSpend < 0)
            throw new IllegalArgumentException("Minimum expenditure cannot be negative");
        this.minimumSpend = minimumSpend;
        if (lastValidDays <= 0)
            throw new IllegalArgumentException("Last valid day cannot be negative or zero");
        this.lastValidDays = lastValidDays;
    }

    public String code()
    {
        return code;
    }

    public long percentage()
    {
        return percentage;
    }

    public long cap()
    {
        return cap;
    }

    public long minimumSpend()
    {
        return minimumSpend;
    }

    public int lastValidDays()
    {
        return lastValidDays;
    }

    public long calculateDiscount(long amount,int day)throws CouponRejectedException
    {
        if(day<lastValidDays) throw new CouponRejectedException("Coupon not valid yet");
        return (long)Math.ceil(amount*percentage/100.0);
    }
}
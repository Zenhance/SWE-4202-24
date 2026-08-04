package kenakata.order;


public class Coupon
{
    private String code;
    private long percentage;
    private long cap;
    private long minimumSpend;
    private int lastValidDays;

    public Coupon(String code, long percentage, long cap, long minimumSpend, int lastValidDays)
    {
        this.code = code;
        this.percentage = percentage;
        this.cap = cap;
        this.minimumSpend = minimumSpend;
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
}
package kenakata.order;

public class PriceBreakdown
{
    private long subtotal;
    private long discount;
    private long vat;
    private long delivery;
    private long insurance;
    private long serviceFee;
    private long grandTotal;

    public PriceBreakdown(long subtotal, long discount, long vat, long delivery, long insurance, long serviceFee, long grandTotal)
    {
        this.subtotal = subtotal;
        this.discount = discount;
        this.vat = vat;
        this.delivery = delivery;
        this.insurance = insurance;
        this.serviceFee = serviceFee;
        this.grandTotal = grandTotal;
    }

    public long subtotal()
    {
        return subtotal;
    }

    public long discount()
    {
        return discount;
    }

    public long vat()
    {
        return vat;
    }

    public long delivery()
    {
        return delivery;
    }

    public long insurance()
    {
        return insurance;
    }

    public long serviceFee()
    {
        return serviceFee;
    }

    public long grandTotal()
    {
        return grandTotal;
    }
}
package kenakata.order;

public class PriceBreakdown {
    private long subtotal;
    private long discount;
    private long delivery;
    private long vat;
    private long insurance;
    private long serviceFee;
    private long grandTotal;

    public PriceBreakdown(long subtotal, long discount, long delivery, long vat, long insurance, long serviceFee) {
        this.subtotal = subtotal;
        this.discount = discount;
        this.delivery = delivery;
        this.vat = vat;
        this.insurance = insurance;
        this.serviceFee = serviceFee;
        this.grandTotal = subtotal - discount + delivery + vat + insurance + serviceFee;
    }
    public long subtotal() {
        return subtotal;
    }
    public long discount() {
        return discount;
    }
    public long delivery() {
        return delivery;
    }
    public long vat() {
        return vat;
    }
    public long insurance() {
        return insurance;
    }
    public long serviceFee() {
        return serviceFee;
    }
    public long grandTotal() {
        return grandTotal;
    }
}
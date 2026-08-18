package kenakata.order;

public class PriceBreakdown {

    private final long subtotal;
    private final long discount;
    private final long vat;
    private final long delivery;
    private final long insurance;
    private final long serviceFee;

    public PriceBreakdown(long subtotal, long discount, long vat, long delivery, long insurance, long serviceFee) {
        this.subtotal = subtotal;
        this.discount = discount;
        this.vat = vat;
        this.delivery = delivery;
        this.insurance = insurance;
        this.serviceFee = serviceFee;
    }

    public long subtotal() {
        return subtotal;
    }

    public long discount() {
        return discount;
    }

    public long vat() {
        return vat;
    }

    public long delivery() {
        return delivery;
    }

    public long insurance() {
        return insurance;
    }

    public long serviceFee() {
        return serviceFee;
    }

    public long grandTotal() {
        return subtotal - discount + vat + delivery + insurance + serviceFee;
    }
}
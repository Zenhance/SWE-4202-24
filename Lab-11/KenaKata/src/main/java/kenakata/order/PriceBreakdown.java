package kenakata.order;

public class PriceBreakdown {
    public final long subtotal;
    public final long discount;
    public final long vat;
    public final long delivery;
    public final long insurance;
    public final long serviceFee;
    public final long grandTotal;

    public PriceBreakdown(long subtotal, long discount, long vat, long delivery, long insurance, long serviceFee, long grandTotal) {
        this.subtotal = subtotal;
        this.discount = discount;
        this.vat = vat;
        this.delivery = delivery;
        this.insurance = insurance;
        this.serviceFee = serviceFee;
        this.grandTotal = grandTotal;
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

    public int grandTotal() {
        return 0;
    }
}


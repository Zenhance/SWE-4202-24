package kenakata.order;

public class PriceBreakdown {
    private final long subtotal;
    private final long discount;
    private final long delivery;
    private final long tax;
    private final long insurance;
    private final long serviceFee;
    private final long grandTotal;

    public PriceBreakdown(long subtotal, long discount, long delivery, long tax, long insurance, long serviceFee, long grandTotal) {
        this.subtotal = subtotal;
        this.discount = discount;
        this.delivery = delivery;
        this.tax = tax;
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
    public long tax() {
        return tax;
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

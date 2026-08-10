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

    public long Subtotal() {
        return subtotal;
    }

    public long Discount() {
        return discount;
    }

    public long Delivery() {
        return delivery;
    }

    public long Vat() {
        return vat;
    }

    public long Insurance() {
        return insurance;
    }

    public long ServiceFee() {
        return serviceFee;
    }
}

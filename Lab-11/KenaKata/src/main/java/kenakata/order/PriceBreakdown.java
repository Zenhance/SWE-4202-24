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

    public long getSubtotal() {
        return subtotal;
    }

    public long getDiscount() {
        return discount;
    }

    public long getDelivery() {
        return delivery;
    }

    public long getVat() {
        return vat;
    }

    public long getInsurance() {
        return insurance;
    }

    public long getServiceFee() {
        return serviceFee;
    }
}

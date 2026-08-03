package kenakata.order;

import java.util.Objects;

public class PriceBreakdown {
    private final long subtotal;
    private final long discount;
    private final long vat;
    private final long delivery;
    private final long insurance;
    private final long serviceFee;
    private final long grandTotal;

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
        return grandTotal;
    }

    public long getSubtotal() {
        return subtotal;
    }

    public long getDiscount() {
        return discount;
    }

    public long getVat() {
        return vat;
    }

    public long getDelivery() {
        return delivery;
    }

    public long getInsurance() {
        return insurance;
    }

    public long getServiceFee() {
        return serviceFee;
    }

    public long getGrandTotal() {
        return grandTotal;
    }
}

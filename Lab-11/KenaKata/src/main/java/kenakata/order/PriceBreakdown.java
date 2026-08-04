package kenakata.order;

import java.util.List;

public final class PriceBreakdown {

    private final long subtotal;
    private final long discount;
    private final long delivery;
    private final long vat;
    private final long insurance;
    private final long serviceFee;
    private final List<OrderLine> lines;

    public PriceBreakdown(long subtotal, long discount, long delivery, long vat, long insurance,
                          long serviceFee, List<OrderLine> lines) {
        this.subtotal = subtotal;
        this.discount = discount;
        this.delivery = delivery;
        this.vat = vat;
        this.insurance = insurance;
        this.serviceFee = serviceFee;
        this.lines = lines;
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
        return subtotal - discount + delivery + vat + insurance + serviceFee;
    }

    public List<OrderLine> lines() {
        return lines;
    }
}


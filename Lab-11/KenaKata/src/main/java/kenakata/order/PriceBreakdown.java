package kenakata.order;

public class PriceBreakdown {
    private long subtotal, discount, delivery, vat, insurance, serviceFee, grandTotal;

    public PriceBreakdown(long subtotal, long discount, long delivery, long vat,
                          long insurance, long serviceFee, long grandTotal) {
        this.subtotal = subtotal;
        this.discount = discount;
        this.delivery = delivery;
        this.vat = vat;
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

    public long grandTotal() {
        return grandTotal;
    }
}


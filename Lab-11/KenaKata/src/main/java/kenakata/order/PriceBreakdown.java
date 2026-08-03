package kenakata.order;

public class PriceBreakdown {
    private final long subtotal;
    private final long discount;
    private final long delivery;
    private final long vat;
    private final long insurance;
    private final long serviceFee;
    private final long grandTotal;
    public PriceBreakdown(long subtotal,
                          long discount,
                          long delivery,
                          long vat,
                          long insurance,
                          long serviceFee) {
        this.subtotal=subtotal;
        this.discount=discount;
        this.delivery=delivery;
        this.vat=vat;
        this.insurance=insurance;
        this.serviceFee=serviceFee;
        this.grandTotal=subtotal-discount+delivery+vat+insurance+serviceFee;
    }

    public double subtotal() {
    return subtotal;
    }

    public double discount() {
    return discount;
    }
    public double delivery() {
    return delivery;
    }
    public double vat() {
    return vat;
    }
    public double insurance() {
    return insurance;
    }
    public double serviceFee() {
    return serviceFee;
    }
    public long grandTotal() {
    return grandTotal;
    }
}

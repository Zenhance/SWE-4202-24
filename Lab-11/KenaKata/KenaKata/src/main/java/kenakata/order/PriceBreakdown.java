package kenakata.order;

public record PriceBreakdown(long subtotal, long discount, long delivery, long vat,
                             long insurance, long serviceFee, long grandTotal) {
    public PriceBreakdown {
        if (subtotal < 0 || discount < 0 || delivery < 0 || vat < 0
                || insurance < 0 || serviceFee < 0 || grandTotal < 0) {
            throw new IllegalArgumentException("Price components cannot be negative");
        }
    }

    public long tax() {
        return vat;
    }
}

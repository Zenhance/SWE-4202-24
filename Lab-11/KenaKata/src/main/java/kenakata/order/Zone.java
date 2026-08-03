package kenakata.order;

public enum Zone {
    DHAKA(60,1),
    OUTSIDE_DHAKA(120,3);
    private final long baseShippingFee;
    private final int estimatedDays;

    Zone(long baseShippingFee, int estimatedDays) {
        this.baseShippingFee = baseShippingFee;
        this.estimatedDays = estimatedDays;
    }
    public long baseShippingFee() {
        return baseShippingFee;
    }

    public int estimatedDays() {
        return estimatedDays;
    }
}

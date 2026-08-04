package kenakata.order;


public enum Zone {
    DHAKA(60, 20),
    OUTSIDE(120, 35);

    private final long baseCharge;
    private final long perKgCharge;

    Zone(long baseCharge, long perKgCharge) {
        this.baseCharge = baseCharge;
        this.perKgCharge = perKgCharge;
    }

    public long baseCharge() {
        return baseCharge;
    }

    public long perKgCharge() {
        return perKgCharge;
    }
}

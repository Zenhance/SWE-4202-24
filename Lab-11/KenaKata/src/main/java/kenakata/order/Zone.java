package kenakata.order;

public enum Zone {
    DHAKA(60, 20),
    OUTSIDE(120, 35);

    private final long baseFee;
    private final long perKgFee;

    Zone(long baseFee, long perKgFee) {
        this.baseFee = baseFee;
        this.perKgFee = perKgFee;
    }

    public long baseFee() {
        return baseFee;
    }

    public long perKgFee() {
        return perKgFee;
    }
}
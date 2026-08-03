package kenakata.order;

public enum Zone {

    DHAKA(60, 20),
    OUTSIDE(120, 35);

    private final long base;
    private final long perKg;

    Zone(long base, long perKg) {
        this.base = base;
        this.perKg = perKg;
    }

    public long base() {
        return base;
    }

    public long perKg() {
        return perKg;
    }
}

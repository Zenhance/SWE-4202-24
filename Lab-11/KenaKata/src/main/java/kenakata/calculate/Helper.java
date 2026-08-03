package kenakata.calculate;

public final class Helper {

    private Helper() {
    }

    public static long ceilPercent(long base, double percent) {
        return (long) Math.ceil(base * percent / 100.0);
    }
}
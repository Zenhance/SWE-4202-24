package kenakata.calculate;

public final class Helper {

    private Helper() {
    }

    public static int ceilPercent(int base, double percent) {
        return (int) Math.ceil(base * percent / 100.0);
    }
}
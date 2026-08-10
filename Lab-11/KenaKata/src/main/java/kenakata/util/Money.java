package kenakata.util;

public final class Money {

    private Money() {}

    public static long ceilPercent(long base, int permille) {
        if (base < 0) {
            throw new IllegalArgumentException("");
        }
        if (permille < 0) {
            throw new IllegalArgumentException("");
        }
        long numerator = base * permille;
        return (numerator + 999) / 1000;
    }
}
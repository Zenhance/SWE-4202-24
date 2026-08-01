package kenakata.catalog;

public final class MoneyMath {
    private MoneyMath(){}
    public static long ceilPercentage(long amount, double percent) {
        return (long) Math.ceil(amount * percent / 100.0);
    }
}

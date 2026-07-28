package kenakata.catalog;

public final class MoneyMath {
    private MoneyMath(){
    }
    public static long ceilFraction(long amount, long numerator, long denominator){
        if(amount < 0 || numerator < 0 || denominator <= 0){
            throw new IllegalArgumentException("Invalid percentage calculation");
        }
        if(amount == 0 || numerator == 0){
            return 0;
        }
        long product = Math.multiplyExact(amount, numerator);
        return product/denominator + (product % denominator == 0 ? 0:1);
    }
    public static long ceilPercent(long amount, long percent){
        return ceilFraction(amount, percent, 100);
    }
}

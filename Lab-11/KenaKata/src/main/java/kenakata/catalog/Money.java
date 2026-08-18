package kenakata.catalog;

public final class Money
{

    private Money()
    {
    }

    public static long ceilDiv(long numerator, long denominator)
    {
        if(denominator <= 0)
        {
            throw new IllegalArgumentException("denominator must be positive");
        }
        if (numerator <= 0)
        {
            return 0;
        }
        return (numerator + denominator - 1) / denominator;
    }
    public static long ceilPercent(long value, long basisPoints)
    {
        return ceilDiv(value * basisPoints, 1000);
    }
}
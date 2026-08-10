package kenakata.catalog;

public interface Chargeable{
    long unitCharge();
    long unitVat();
    long commissionOn(long value);
    String label();
}
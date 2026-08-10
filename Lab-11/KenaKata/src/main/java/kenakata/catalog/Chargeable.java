package kenakata.catalog;

public interface Chargeable {
    String label();

    long unitCharge();

    long unitVat();
}

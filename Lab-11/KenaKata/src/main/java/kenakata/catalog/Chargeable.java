package kenakata.catalog;

public interface Chargeable {
    long unitVat();
    long unitCharge();

    String label();

}

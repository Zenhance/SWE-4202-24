package kenakata.catalog;

public interface Chargable {
    String label();

    long unitCharge();

    long unitVat();
}

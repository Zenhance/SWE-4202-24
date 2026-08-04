package kenakata.catalog;

public interface Chargeable {
    long UnitCharge();
    long unitVat();

    String label();

    long unitPrice();

    long unitCharge();


}

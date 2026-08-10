package main.java.kenakata.catalog;

public interface Chargeable {

    long unitCharge();
    long unitVat();
    String label();
}

package kenakata.order;
public interface Chargeable {
    long unitCharge();
    long unitVat();
    String label();
}
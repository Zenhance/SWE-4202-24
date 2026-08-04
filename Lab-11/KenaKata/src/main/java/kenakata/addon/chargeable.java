package kenakata.addon;

public interface chargeable {
    long unitCharge();
    long unitVat();

    String label();
}

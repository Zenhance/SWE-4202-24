package kenakata.catalog;

public interface Chargeable {
    int unitCharge();
    int unitVat();
    int commissionOn(int something);
}

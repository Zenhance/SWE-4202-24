package kenakata.catalog;

public interface Chargeable {

    long unitCharge();

    long unitVat();

    default String label(){
        return " ";
    }
}

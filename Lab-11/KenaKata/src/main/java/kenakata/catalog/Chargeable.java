package kenakata.catalog;

public interface Chargeable {
    long unitVat();
    long unitCharge();
    default boolean isWeighable() {
        return false;
    }
    default boolean returnable(){
        return false;
    }
    default boolean insurable(){
        return false;
    }



    default double weight(){
        return 0;
    }
    default int returnDays(){
        return 0;
    }


}

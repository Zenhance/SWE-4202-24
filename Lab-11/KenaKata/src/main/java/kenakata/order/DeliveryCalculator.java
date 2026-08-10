package kenakata.order;
public class DeliveryCalculator {
    public DeliveryCalculator() {
    }
    public long calculate(Zone zone, long totalWeightGrams, int freshLineCount) {
        if (zone == null) {
            throw new IllegalArgumentException("Zone cannot be null");
        }
        if (totalWeightGrams < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        if (freshLineCount < 0) {
            throw new IllegalArgumentException("Fresh line count cannot be negative");
        }
        if (totalWeightGrams == 0){
            return 0;
        }
        long billedKg = (totalWeightGrams + 999) / 1000;
        long delivery;
        if (zone == Zone.DHAKA) {
            delivery = 60 + (billedKg * 20);
        } else {
            delivery = 120 + (billedKg * 35);
        }
        delivery += freshLineCount * 50L;
        return delivery;
    }
}
package kenakata.enums;

public class DeliveryLoc {
    private double baseFee;
    private double perKgFee;

    DeliveryLoc(double baseFee, double perKgFee) {
        this.baseFee = baseFee;
        this.perKgFee = perKgFee;
    }

    public double getBaseFee() {
        return baseFee;
    }

    public double getPerKgFee() {
        return perKgFee;
    }
}
package kenakata.enums;

public class ItemType {
    private double vatRate;
    private double commissionRate;

    public ItemType(double vatRate, double commissionRate) {
        this.vatRate = vatRate;
        this.commissionRate = commissionRate;
    }

    public double getVatRate() {
        return vatRate;
    }

    public double getCommissionRate() {
        return commissionRate;
    }
}

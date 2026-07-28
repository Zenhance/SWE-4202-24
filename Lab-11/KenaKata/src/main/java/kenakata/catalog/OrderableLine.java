package kenakata.catalog;

public interface OrderableLine {
    String getReceiptLabel();
    long getCharge(int quantity);
    long getVat(int quantity);
}

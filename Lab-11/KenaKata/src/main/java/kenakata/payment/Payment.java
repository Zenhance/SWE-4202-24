package kenakata.payment;

public interface Payment {
    boolean authorize(int amount);
}

package wallet;

import exceptions.InsufficientBalanceException;
public abstract class Wallet{
    private String id;
    private double balance;
    private String pin;
    private boolean frozen;
    private double spentToday;

    public Wallet(String id, double balance, String pin) {
        if (id ==null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("id cannot be Null or empty");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("balance cannot be less than zero");
        }
        if (pin == null || pin.trim().isEmpty()) {
            throw new IllegalArgumentException("pin cannot be Null or empty");
        }


    }}
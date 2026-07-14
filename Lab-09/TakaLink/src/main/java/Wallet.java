package main.java;

public  abstract class Wallet {
    private String id;
    private double balance;
    private String pin;
    private boolean frozen;
    private double spentToday;
    public Wallet(String id,double balance,String pin) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("You must provide your id");
        if(balance<0){
            throw new IllegalArgumentException("balance cannot be negative");
        }
        if(pin== null || pin.isBlank()){
            throw new IllegalArgumentException("pin cannot be null");
        }
    }
}

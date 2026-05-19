package model;

public class Customer {
    private int id;
    private String name;
    private int age;
    private String loyaltyTier;


    public Customer(int id, String name, int age, String tier){
        this.id=id;
        this.name=name;
        this.age=age;
        this.tier=tier;

    }
}

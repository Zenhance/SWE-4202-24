package model;

public class Customer {

    //fields
    public int id;
    public String name;
    public int age;
    public String loyaltyTier;

    //constructors
    public Customer(int id, String name, int age){

        this.id = id;
        this.name = name;
        this.age = age;
        loyaltyTier = "BASIC";
    }

    public Customer(int id, String name, int age, String tier) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.tier = tier;

    }


}
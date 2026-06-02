package model;

import java.util.Objects;

public class Customer {
    int id;
    String name;
    int age;
    String loyaltyTier;
    public Customer(int id, String name, int age){
        this.id=id;
        this.name=name;
        this.age=age;
        loyaltyTier="BASIC";
    }
    public Customer(int id, String name, int age, String tier){
        this.id=id;
        this.name=name;
        this.age=age;
        this.loyaltyTier=tier;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getLoyaltyTier() {
        return loyaltyTier;
    }

    public String getName() {
        return name;
    }

    public double getTierDiscount(){
        if(Objects.equals(loyaltyTier, "SILVER")) return 0.08;
        else if(Objects.equals(loyaltyTier, "GOLD")) return 0.15;
        else return 0;
    }

}

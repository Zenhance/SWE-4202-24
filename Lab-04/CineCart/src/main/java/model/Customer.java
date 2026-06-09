package model;

public class Customer {
     int id;
     String name;
     int age;
     String loyaltyTier;
    public Customer(int id, String name, int age, String tier){
        this.id = id;
        this.name = name;
        this.age =age;

        this.loyaltyTier = tier;
    }

    public Customer(int id, String name, int age){
        this.id= id;
        this.age=age;
        this.name=name;
        loyaltyTier = "Basic";
    }
}

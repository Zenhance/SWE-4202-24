package model;

public class Customer {
    private int id ,age;
    private String name ,loyaltyTier;

    public Customer(int id, String name, int age){
        this.id=id;
        this.age=age;
        this.name=name;
    }
    public Customer(int id, String name, int age, String tier){
        this.id=id;
        this.age=age;
        this.name=name;
        loyaltyTier=tier;
    }
    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }




}
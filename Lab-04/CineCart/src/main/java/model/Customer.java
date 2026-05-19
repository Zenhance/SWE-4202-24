package model;

public class Customer {
    private int id;
    private String name;
    private int age;
    private String loyatyTier="BASIC";

    Customer(int id, String name, int age) {
        this.id=id;
        this.name=name;
        this.age=age;
    }

    Customer(int id, String name, int age, String tier) {
        this.id=id;
        this.name=name;
        this.age=age;
        this.loyatyTier=tier;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getLoyatyTier() {
        return loyatyTier;
    }
}

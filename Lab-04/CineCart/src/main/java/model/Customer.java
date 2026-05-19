package model;

public class Customer {
    private int id;
    private String name;
    private int age;
    private String loyaltyTier="BASIC";

    Customer(int id, String name, int age) {
        this.id=id;
        this.name=name;
        this.age=age;
    }

    Customer(int id, String name, int age, String tier) {
        this.id=id;
        this.name=name;
        this.age=age;
        this.loyaltyTier=tier;
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
        return loyaltyTier;
    }

    public double getTierDiscount() {
        if(this.loyaltyTier=="GOLD") {
            return 0.15;
        }
        else if(this.loyaltyTier=="SILVER") {
            return 0.08;
        }
        else
            return 0.00;
    }

    public String toString() {
        return String.format("hi");
    }
}

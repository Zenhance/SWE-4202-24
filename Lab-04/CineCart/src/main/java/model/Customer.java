package model;

public class Customer {

    private int id;
    private String name;
    private int age;
    private String loyaltyTier;

    public Customer(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        loyaltyTier = "BASIC";
    }

    public Customer(int id, String name, int age, String tier) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.loyaltyTier = tier;
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

    public String getLoyaltyTier() {
        return loyaltyTier;
    }

    public double getTierDiscount() {
        double state = 0.0;
        if (loyaltyTier.equals("GOLD")) state = 0.15;
        else if (loyaltyTier.equals("SILVER")) state = 0.08;
        return state;
    }

    public String toString() {
        return id + name + age + loyaltyTier;
    }
}
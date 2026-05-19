package model;

public class Customer {
    private int id;
    private String name;
    private int age;
    private String loyaltyTier;

    public Customer(int id, String name, int age, String tier) {
        this.id = id;
        this.name= name;
        this.age = age;
        loyaltyTier = tier;
    }

    public Customer(int id, String name, int age) {
        this(id, name, age, "BASIC");
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

    public String getLoyaltyTier() {
        return loyaltyTier;
    }

    public double getTierDiscount() {
        if (loyaltyTier.equals("GOLD")) return 0.15;
        if (loyaltyTier.equals("SILVER")) return 0.08;
        return 0.00;
    }

    public String toString() {
        String string = String.format("%d %s %d %s", id, name, age, loyaltyTier);
        return string;
    }
}

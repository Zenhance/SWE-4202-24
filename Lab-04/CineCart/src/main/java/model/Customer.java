package model;

// Customer is the person who walks up to the booking booth.
// They have an age (for rating checks) and a loyalty tier (for discounts).
public class Customer {

    // --- Fields ---
    private int id;
    private String name;
    private int age;
    private String loyaltyTier;  // "BASIC", "SILVER", or "GOLD"

    // --- Constructor 1: no tier given, defaults to "BASIC" ---
    public Customer(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.loyaltyTier = "BASIC";  // new customers start at basic level
    }

    // --- Constructor 2: tier is explicitly provided ---
    public Customer(int id, String name, int age, String tier) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.loyaltyTier = tier;
    }

    // --- Getters ---
    public int getId()              { return id; }
    public String getName()         { return name; }
    public int getAge()             { return age; }
    public String getLoyaltyTier()  { return loyaltyTier; }

    // Returns the discount fraction this customer gets based on their loyalty tier.
    // GOLD members save 15%, SILVER saves 8%, BASIC gets nothing.
    public double getTierDiscount() {
        if (loyaltyTier.equals("GOLD"))   return 0.15;
        if (loyaltyTier.equals("SILVER")) return 0.08;
        return 0.00;  // BASIC = no discount
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ", Tier: " + loyaltyTier + ")";
    }
}

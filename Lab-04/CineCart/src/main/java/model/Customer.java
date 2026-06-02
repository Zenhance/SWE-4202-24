package model;

public class Customer {
    private final int id;
    private final String name;
    private final int age;
    private final String loyaltyTier;

    public Customer(int id, String name, int age, String tier) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.loyaltyTier = tier;
    }

    public Customer(int id, String name, int age){
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

    public double getTierDiscount(){
        return switch (loyaltyTier){
            case "GOLD" -> 0.15;
            case "SILVER" -> 0.08;
            default -> 0.00;
        };
    }

    public String toString(){
        String out = String.format("[T%d] %s (%d yrs) [%s]", id, name, age, loyaltyTier);
        return out;
    }

}



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
        this.loyaltyTier = "BASIC";
    }

    public Customer(int id, String name, int age, String loyaltyTier) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.loyaltyTier = loyaltyTier;
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
        switch (loyaltyTier){
            case "GOLD": return 0.15;
            case "SILVER": return 0.08;
            default: return 0.00;
        }
    }
    public String toString() {
        return String.format("Customer{id=%d, name='%s', age=%d, tier=%s}", id, name, age, loyaltyTier);
    }



}

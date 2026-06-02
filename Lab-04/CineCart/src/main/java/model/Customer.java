package model;

public class Customer {
    private int id;
    private String name;
    private int age;
    private String loyaltyTier;

    public Customer(int id, Movie movie, Hall hall, int startHour){
        this.id = id;
        this.name = name;
        this.age = age;
        loyaltyTier = tier;
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
        if (loyaltyTier.equals("GOLD")) return 0.15;
        if (loyaltyTier.equals("SILVER")) return 0.08;
        return 0.00;
    }

    public toString(){
        String string = String.format("%d %s %d %s",id ,name, age, loyaltyTier);
        return string;
    }
}

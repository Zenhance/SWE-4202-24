package model;

public class Customer {
    //int id, String name, int age, String loyaltyTier (one of "BASIC", "SILVER", "GOLD").
    private final int id;
    private final String name;
    private final int age;
    private final String loyaltyTier;

    public Customer(int id, String name, int age, String tier){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("name cannot be null or blank");
        }
        if(age < 0 || age > 130){
            throw new IllegalArgumentException("age should be between 0 and 130");
        }
        if(!tier.equals("BASIC")&&!tier.equals("SILVER")&&!tier.equals("GOLD")){
            throw new IllegalArgumentException("tier should be either BASIC or SILVER or GOLD");
        }
        this.id = id;
        this.name = name;
        this.age = age;
        this.loyaltyTier = tier;
    }
    public Customer(int id, String name, int age){
        this(id,name,age,"BASIC");
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getLoyaltyTier(){
        return loyaltyTier;
    }
     public double getTierDiscount(){
        return switch(loyaltyTier){
            case "GOLD" -> 0.15;
            case "SILVER" -> 0.08;
            default -> 0.00;
        };
     }

     public String toString(){
        return String.format("[%d] %s, Age: %d, Tier: %s", id,name,age,loyaltyTier);
     }
}

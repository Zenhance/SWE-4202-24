package model;

public class Customer {
    private final int id ,age;
    private final String name ,loyaltyTier;

    public Customer(int id, String name, int age){
        this.id=id;
        this.age=age;
        this.name=name;
        loyaltyTier="BASIC";
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

    public String getLoyaltyTier() {
        return loyaltyTier;
    }

    public String getName() {
        return name;
    }
    public double getTierDiscount(){
        if(loyaltyTier.equals("GOLD"))
            return 0.15;
        else if(loyaltyTier.equals("SILVER"))
            return 0.08;
        else return 0.00;
    }

    public String toString(){
        return id+name+age+loyaltyTier;
  }


}
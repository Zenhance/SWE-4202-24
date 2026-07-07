package model;

public class Customer {
    private int id;
    private String name;
    private int age;
    private String loyaltyTier;

    public Customer(int id, String name, int age){
        this.loyaltyTier="BASIC";
        this.id=id;
        this.name=name;
        this.age=age;

    }
    public Customer(int id, String name, int age, String loyaltyTier){
        this.id=id;
        this.name=name;
        this.age=age;
        this.loyaltyTier=loyaltyTier;
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
    public double getTierDiscount(){
        double ret;
        if(getLoyaltyTier()=="GOLD"){
            ret=0.15;
        }
        else if(getLoyaltyTier()=="SILVER"){
            ret=0.08;
        }
        else{
            ret=0;
        }
        return ret;
    }

    public String toString(){
        return "[Customer #" + id + "] " + name + " | Age: " + age + " | Tier: " + loyaltyTier;
    }

}

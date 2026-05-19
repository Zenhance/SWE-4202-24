package model;

public class Customer {
    private int id;
    private String name;
    private int age;
    private String loyaltyTier;
    //constructor
    public Customer{
        this.id=id;
        this.name=name;
        this.age=age;
        this.loyaltyTier="BASIC";
    }
    public Customer{
        this.id=id;
        this.name=name;
        this.age=age;
        this.loyaltyTier=tier;
    }
//getters
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
        return tier;
    }
    public double getTierDiscount() {
        if(loyaltyTier.equals("GOLD")) ;
        {
            return 0.15;
        }
        if(loyaltyTier.equals("SILVER")) ;
        {
            return 0.08;
        }
        return 0.0;
    }











}

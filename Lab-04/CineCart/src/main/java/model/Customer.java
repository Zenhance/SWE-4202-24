package model;

public class Customer {
    private int id;
    private String name;
    private int age;
    private String loyaltyTier;

    public Customer(int id, String name, int age){
        this.id=id;
        this.name=name;
        this.age=age;
        this.loyaltyTier="BASIC";
    }
    public Customer(int id, String name, int age,String tier){
        this.id=id;
        this.name=name;
        this.age=age;
        this.loyaltyTier=tier;

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
    double getTierDiscount(){
        if(loyaltyTier=="GOLD"){
            return 0.15;
        }
        else if(loyaltyTier=="SILVER"){
            return 0.08;
        }
        else{
            return 0;
        }
    }

    public String toString()
    {
        String s;
        s="Customer ID : " + getId() + " name: " + getName() + " age: "+ getAge() +" loyalty status: "+ getLoyaltyTier();
        return s;
    }
}

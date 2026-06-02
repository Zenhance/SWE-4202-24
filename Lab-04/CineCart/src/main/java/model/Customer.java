package model;

public class Customer {
    int id;
    String name;
    int age;
    String loyaltyTier;

    public Customer(int id, String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
        this.loyaltyTier="BASIC";
    }
    public Customer(int id, String name,int age,String loyaltyTier){
        this.id=id;
        this.name=name;
        this.age=age;
        this.loyaltyTier=loyaltyTier;
    }

    public int getId() {
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
        if(loyaltyTier=="GOLD"){
            return 0.15;
        }
        if(loyaltyTier=="SILVER"){
            return 0.08;
        }
        return 0.00;
    }
}

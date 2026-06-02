package model;

public class Customer {
    int id;
    String name;
    int age;
    String loyaltyTier;
    Customer(int id,String name, int age){
        this.id=id;
        this.name=name;
        this.age=age;
        this.loyaltyTier="BASIC";
    }
    Customer(int id,String name, int age, String loyaltyTier){
        this.id=id;
        this.name=name;
        this.age=age;
        this.loyaltyTier=loyaltyTier;
    }
    int getId(){
        return id;
    }
    String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    String getLoyaltyTier(){
        return loyaltyTier;
    }
    double getTierDiscount(){
        if(loyaltyTier.equals("GOLD")){
            return 0.15;
        }
        else if(loyaltyTier.equals("SILVER")){
            return 0.08;
        }
        else return 0.00;
    }
    public String toString(){
        return String.format("%d,%s,%d,%s", id,name,age,loyaltyTier);
    }
}

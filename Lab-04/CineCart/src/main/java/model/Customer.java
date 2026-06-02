package model;

public class Customer {
    private int id;
    private String name;
    private int age;
    private String loyaltyTier;

    Customer(int id,String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
        this.loyaltyTier="BASIC";
    }
    Customer(int id,String name,int age,String tier){
        this.id=id;
        this.name=name;
        this.age=age;
        this.loyaltyTier=tier;
    }
    public double getTierDiscount(){
        if(this.loyaltyTier.equals("GOLD")){
            return 0.15;
        }
        if(this.loyaltyTier.equals("SILVER")){
            return 0.08;
        }
        else{
            return 0.00;
        }
    }

    public getAge(){
        return age;
    }
    public String toString(){
        return id+" "+name+" "+age+" "+loyaltyTier;
    }
}

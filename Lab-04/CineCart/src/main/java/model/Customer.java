package model;

public class Customer {
    private int id;
    private String name;
    private int age;
    private String loyaltyTier;

    public Customer(int id,String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
        this.loyaltyTier="BASIC";
    }
    public Customer(int id,String name,int age,String tier){
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
    public double getTierDiscount(){
        double res=0.00;
        if(loyaltyTier.equals("GOLD")){
            res=0.15;
        }
        else if (loyaltyTier.equals("SILVER")) {
            res=0.08;
        }
        return res;
    }

    @Override
    public String toString() {
        return id+name+age+loyaltyTier;
    }
}

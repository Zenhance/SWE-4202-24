package model;

public class Customer {
    private final int id;
    private final String name;
    private final int age;
    private final String loyaltyTier;
    private Ticket[] ticket;

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

    public int getAge(){
        return age;
    }
    public int getId(){return id;}
    public String toString(){
        return id+" "+name+" "+age+" "+loyaltyTier;
    }
public String getLoyaltyTier(){
        return loyaltyTier;
}
    public String getName() {
        return name;
    }
}

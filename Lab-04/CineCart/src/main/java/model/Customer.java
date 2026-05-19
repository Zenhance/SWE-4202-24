package model;

public class Customer {
    private int id;
    private String name;
    private int age;
    private String loyaltyTier;
    public Customer(int id,String name,int age){
        this(id, name, age, "BASIC");
    }
    public Customer(int id,String name,int age,String tier){
        this.id=id;
        this.name=name;
        this.age=age;
        this.loyaltyTier=loyaltyTier;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLoyaltyTier() {
        return loyaltyTier;
    }
    public double getTierDiscount(){
        if(loyaltyTier.equals("GOLD")){
            return 0.15;
        }
        else if(loyaltyTier.equals("SILVER")){
            return 0.08;
        }
        else{
            return 0.00;
        }
    }
    public String toString(){
        return id+name+age+loyaltyTier;
    }

}

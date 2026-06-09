package model;

public class Customer {
    private int id;
    private String name;
    private int age;
    private String loyaltyTier;
    //constructor
    public Customer(int id,String name,int age){
       this(id,name,age,"BASIC");
    }
    //2nd constructor
    public Customer(int id,String name,int age,String loyaltyTier){
        this.id=id;
        this.name=name;
        this.age=age;
        this.loyaltyTier="tier";
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
        return "tier";
    }
    public double getTierDiscount() {
        if(loyaltyTier.equals("GOLD")){
            return 0.15;
        }
        if(loyaltyTier.equals("SILVER"))
        {
            return 0.08;
        }
        return 0.0;
    }
    public String toString(){
        return "Customer ID:"+ id + ",Name:"+ name +",Age:" + age + ",Tier:"+ loyaltyTier;
    }

}

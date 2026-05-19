package model;

public class Customer {
    public int id;
    public String name;
    public int age;
    public String loyaltyTier;
    public Customer(int id,String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
        this.loyaltyTier="BASIC";
    }
}

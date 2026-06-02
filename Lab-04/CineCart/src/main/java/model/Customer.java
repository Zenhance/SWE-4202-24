package model;

public class Customer {
    int id;
    String name;
    int age;
    String loyaltyTier;
    public Customer(int id, String name, int age){
        this.id=id;
        this.name=name;
        this.age=age;

    }
    public Customer(int id, String name, int age, String tier){
        this.id=id;
        this.name=name;
        this.age=age;
        this.loyaltyTier=tier;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    public String getLoyaltyTier(){
        return loyaltyTier;
    }
    public double getTierDiscount(){
        if(loyaltyTier=="GOLD"){
            return 0.15;
        }
        else if(loyaltyTier=="SILVER"){
            return 0.08;
        }
        else{
            return 0.00;
        }
    }
    public String toString(){
        return "["+id+"] "+name+"[ "+loyaltyTier+"]";
    }
}

package model;

public class Customer {
    int id;
    String name;
    int age;
    String loyaltyTier;

    public Customer(int id, String name, int age, String tier) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.loyaltyTier = tier;
    }

    public Customer(int id, int age, String tier) {
        this.id = id;
        this.age = age;
        tier = "BASIC";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTier() {
        return loyaltyTier;
    }
    public double getTierDiscount(){
        if(loyaltyTier=="GOLD")return 0.15;
        else if (loyaltyTier=="SILVER") {
            return 0.08;

        }
        else return 0.00;


    }
    public String toString(){
           return "("+id+")"+" "+name+" "+age+" "+loyaltyTier;
    }
}

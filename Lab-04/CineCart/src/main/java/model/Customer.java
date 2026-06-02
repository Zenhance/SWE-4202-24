package model;

public class Customer {

private int id;
private String name;
private int age;
private String loyaltyTier;

public Customer(int id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;

}
 public  Customer(int id, String name, int age, String tier) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.loyaltyTier = "BASIC";

    }
public String getLoyaltyTier() {
    return loyaltyTier;
}



    public double getTierDiscount(){
    if(loyaltyTier.equals ("GOLD")) {
        return 0.15;
        }
        else if(loyaltyTier.equals ("SILVER")) {
        return 0.08;
    }
    else
        return 0.0;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", loyaltyTier=" + loyaltyTier +
                '}';
    }
}

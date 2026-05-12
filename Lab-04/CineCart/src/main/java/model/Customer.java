package model;

public class Customer {
    int id;
    String name;
    int age;
    String loyaltyTier;
    public Customer(int id, String name, int age) {
        this.id = id;
        this.name = name;
    loyaltyTier = "BASIC";
    }
   public Customer(int id, String name, int age, String tier){
        this.id = id;
        this.name = name;
        this.age = age;
        tier = sc.nextLine();
   }
   double getTierDiscount(){
     if (loyaltyTier == "GOLD"){
         return 0.15;
     }
     if(loyaltyTier == )
   }
   String toString(){
        return id + name + loyaltyTier;
   }
}

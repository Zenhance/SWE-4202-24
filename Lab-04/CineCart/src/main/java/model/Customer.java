package model;

public class Customer {
    private int id;
    private String name;
    private int age;
    private String loyaltyTier;

    public Customer(int id, String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
        this.loyaltyTier="BASIC";
    }

    public Customer(int id, String name,int age, String loyaltyTier){
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

    public int getAge() {
        return age;
    }

    public String getLoyaltyTier() {
        return loyaltyTier;
    }

    public double getTierDiscount(){
        double  discountAmount=0;
        if("GOLD".equals(loyaltyTier)){
            discountAmount=0.15;
        }else if( "SILVER".equals(loyaltyTier)){
            discountAmount=0.08;
        }else{
            discountAmount=0.00;
        }
        return discountAmount;
    }

    public String toString(){
        String res= id+name+age+loyaltyTier;
        return res;
    }
}

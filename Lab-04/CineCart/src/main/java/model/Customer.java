package model;

public class Customer {
    private int id;
    private String name;
    private int age;
    private String loyaltyTier;

    public Customer(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
        this.loyaltyTier = "BASIC";
    }

    public Customer(int id, String name, int age, String tier){
        this.id = id;
        this.name = name;
        this.age = age;
        this.loyaltyTier = tier;
    }



    public int getAge() {
        return age;
    }

    public String getTier() {
        return loyaltyTier;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getTierDiscount(){
        double discount = 0.00;
        if(loyaltyTier.equals("GOLD")) discount = 0.15;
        if(loyaltyTier.equals("SILVER")) discount = 0.08;

        return discount;
    }





}
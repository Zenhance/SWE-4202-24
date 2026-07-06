package model;

public class Customer
{
    private int id;
    private String name;
    private int age;
    private String loyaltyTier;

    public Customer(int id, String name, int age)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.loyaltyTier = "BASIC";
    }

    public Customer(int id, String name, int age, String tier)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.loyaltyTier = tier;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public String getLoyaltyTier()
    {
        return loyaltyTier;
    }

    public double getTierDiscount()
    {
        if(loyaltyTier.equals("GOLD"))
        {
            return 0.15;
        }
        if(loyaltyTier.equals("SILVER"))
        {
            return 0.08;
        }
        return 0.0;
    }

    public String toString()
    {
        return id+" - "+name+" - "+age+" - "+loyaltyTier;
    }
}
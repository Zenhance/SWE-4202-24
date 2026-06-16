package model;

public class Customer {
    private double tierDiscount;
 public Customer(double tierDiscount){
     this.tierDiscount=tierDiscount;
 }

    public double getTierDiscount() {
        return tierDiscount;
    }
}


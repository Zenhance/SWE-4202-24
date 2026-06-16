package model;

public class Showtime {
    private double basePrice;
    private boolean peak;
    public Showtime(double basePrice,boolean peak){
        this.basePrice=basePrice;
        this.peak=peak;
    }
    public double getBasePrice(){
        return basePrice;
    }
    public boolean isPeak(){
        return peak;
    }

}



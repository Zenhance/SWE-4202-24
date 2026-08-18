package src.main.java;

public class Slot {
    private boolean isFree;
    private int firstHourFee;
    private int laterHourFee;
    private int surcharge;

    public Slot(){
        this.isFree = true;
    }

    public void setFirstHourFee(int firstHourFee) {
        if(firstHourFee<=0){
            throw new IllegalArgumentException("First hour fee can't be zero or negative");
        }

        this.firstHourFee = firstHourFee;
    }

    public void setLaterHourFee(int laterHourFee){
        if (laterHourFee<=0){
            throw new IllegalArgumentException("LaterhourFee can't be zero or negative");
        }
        this.laterHourFee = laterHourFee;
    }

    public void setSurcharge(int surcharge) {
        if(surcharge<=0)
        throw new IllegalArgumentException("Surcharge can't be zero or negative");
        this.surcharge = surcharge;
    }
    public int getFirstHourFee(){
        return firstHourFee;
    }
    public int getLaterHourFee(){
        return laterHourFee;
    }
    public int getSurcharge(){
        return surcharge;
    }
}

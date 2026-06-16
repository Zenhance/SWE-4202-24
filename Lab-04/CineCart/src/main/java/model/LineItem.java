package model;

public abstract class LineItem {
    public abstract double subtotal();
    public abstract String describe();
    public int ticketCount(){
        return 0;
    }
    public boolean hasCode(String code){
        return false;
    }

    public abstract boolean hasCoode(String code);
}

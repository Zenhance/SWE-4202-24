package model;

public abstract class LineItem {
    public abstract double subtotal();
    public abstract String describe();
    public boolean isTicket(){
        return false;
    }
    public boolean hasTicket(String code){
        return false;
    }
}

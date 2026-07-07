package model;

public abstract class LineItem {
    public abstract double subtotal();
    public String describe(){
    return "";
    }
    public boolean isTicket(){
        return false;
    }
    public boolean hasCode(String code){
        return false;
    }
}
package model;

public abstract class LineItem {
    protected  abstract double subtotal();
    protected abstract String describe();
    public boolean isTicket(){
        return false;
    }
    public boolean hasCode(String code){
        return false;
    }
}

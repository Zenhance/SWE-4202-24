package model;

public abstract class LineItem {
    public abstract double subtotal();
    public abstract String describe();


    public boolean isTicket() {
        return false;
    }



    public boolean containsCode(String code) {
        return false;
    }
}

}

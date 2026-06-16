package model;

public interface LineItem {
    double subtotal();
    String describe();

    default boolean isTicketLine() {
        return false;
    }

    default boolean carriesCode(String code) {
        return false;
    }
}
package kenakata.settlement;

public class Seller{
    private String name;

    public Seller(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("seller name must not be blank");
        }
        this.name = name;
    }
    public Seller(){}

    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

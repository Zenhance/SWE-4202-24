package kenakata.catalog;

public class Seller {
    private String name;


    public Seller(String name) {
        if (name == null)
            throw new IllegalArgumentException("Name cannot null");
        if (name.isBlank())
            throw new IllegalArgumentException("Name cannot be blank");
        this.name = name;
    }
}

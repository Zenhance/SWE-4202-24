package kenakata.catalog;

public class Seller {
    private String name;

    public Seller(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Seller name can not be blank.");
        }

        this.name = name;
    }

    public String name() {
        return name;}
}

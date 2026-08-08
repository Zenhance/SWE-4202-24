package kenakata.catalog;

public class Seller {
    private String  name;
    public Seller(String name) {
        if(name== null || name.isBlank())
            throw new IllegalArgumentException("name cannot be null or empty");
        this.name=name;

    }

    public String getName() {
        return name;
    }
}

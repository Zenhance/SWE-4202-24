package kenakata.catalog;


import java.util.Objects;

public class Seller {
    private String name;
    public Seller(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Seller can't be empty");
        }

        this.name=name;
    }
    public String name(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return Objects.equals(name, seller.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}

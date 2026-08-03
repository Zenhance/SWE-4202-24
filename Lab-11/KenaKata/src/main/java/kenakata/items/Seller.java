package kenakata.items;

public class Seller {
    private final String name;
    public Seller(String name){
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("seller name must not be blank");
        }
        this.name=name;
    }
    @Override
    public String toString(){
        return name ;
    }
}

package kenakata.catalog;

public class Seller {
    private final String name;
    public Seller(String name){
if(name==null || name.isBlank()){
    throw new IllegalArgumentException();

}
this.name=name;
    }

    public String getName() {
        return name;
    }
}

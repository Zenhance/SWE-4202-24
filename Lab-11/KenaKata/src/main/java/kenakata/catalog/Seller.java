package kenakata.catalog;

public class Seller {
    private String id;
    private String name;
    public Seller(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Seller(String name) {
        this.name = name;
    }
    public String getId(){return id;}
    public String getName(){return name;}

}

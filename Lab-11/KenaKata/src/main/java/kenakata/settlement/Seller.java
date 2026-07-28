package kenakata.settlement;

public class Seller {
    private final String id;
    private final String name;

    public Seller(String id, String name) {
        if(id==null || id.isBlank() || name==null || name.isBlank()){
            throw new IllegalArgumentException(("it is invalid"));
        }
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }
}

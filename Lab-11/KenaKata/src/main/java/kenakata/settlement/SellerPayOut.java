package kenakata.settlement;

public class SellerPayOut {
    private final String id;
    private final String name;

    public SellerPayOut(String id, String name) {
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

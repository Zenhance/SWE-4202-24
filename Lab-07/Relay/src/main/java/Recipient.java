public abstract class Recipient {
    private final String name, address ;

    public Recipient(String name,String address){

        this.name=name;
        this.address=address;
    }
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    public abstract String deliver();

    public abstract double cost();

    public abstract String describe();
}

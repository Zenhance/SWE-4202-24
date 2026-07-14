public class Recipient {
    private final String name;
    private final String address;

    public Recipient(String name, String address){
        this.name=name;
        this.address=address;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }
}

public class Recipient {
    private final String name;
    private final String address;

    public Recipient(String name, String adddress){
        this.name = name;
        this.address = adddress;
    }

    public String getName() {
        return name;
    }
    public String getAddress(){
        return address;
    }
}

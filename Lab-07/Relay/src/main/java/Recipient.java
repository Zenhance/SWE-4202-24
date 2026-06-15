public class Recipient {
    private String name;
    private String address;

    public Recipient(String name, String address){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name needed");
        }
        if(address == null || address.isEmpty()){
            throw new IllegalArgumentException("Address needed");
        }
        this.name = name;
        this.address = address;
    }
}

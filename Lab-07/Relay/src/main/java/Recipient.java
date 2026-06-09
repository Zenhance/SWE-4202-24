public class Recipient {
    private String  name;
    private String address;
    public Recipient(String name, String address) {
        if(name.isEmpty() || address.isEmpty()){
            throw new IllegalArgumentException("Recipient name or address cannot be empty");
        }
        this.name = name;
        this.address = address ;
    }

}

public class Recipient {
    private final String name;
    private final String address;

    public Recipient(String name, String address){
        if(name.isEmpty() || address.isEmpty()){
            throw new IllegalArgumentException("Recipient name or address cannot be empty");
        }
        this.name= name;
        this.address=address;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }


}

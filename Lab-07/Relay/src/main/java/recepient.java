public class recepient {
    private String name;
    private String address;

    public recepient (String name, String address){
        if (name==null) || name.isBlank(){
            throw new IllegalArgumentException(" No Name ");
        }
        if (address == null) || address.isBlank(){
            throw new IllegalArgumentException("No Address");
        }
        this.name = name;
        this.address = address;
    }
}

public class Recipient {
    private static String name;
    private static String address;

    public Recipient(String name,String address){
        this.name=name;
        this.address=address;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
}

public class Recipient {
    String Name;
    String Address;
    public Recipient(String Name,String Address){
        if(Name == null || Name.isBlank()){
            throw new IllegalArgumentException("No name");
        }

        if (Address == null || Address.isBlank()){
            throw new IllegalArgumentException("No address");}
        this.Name=Name;
        this.Address=Address;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }
}

public class Recipient {
    private String name;
    private String address;

    public Recipient(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String toString() {
        return ("Name: " + name + " Email: " + address);
    }
}

public class Recipient {
      String name;
      String address;
    public Recipient(String name, String address) {
        this.name=name;
        this.address=address;
    }

    public String getName() {
        return name;
    }

    public CharSequence getAddress() {
        return address;
    }
}

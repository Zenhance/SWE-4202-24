public class Recipient {
    private String name;
    private String email;

    public Recipient(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String str = "";
        str += "Name: " + name + "\n";
        str += "Email: " + email + "\n";
        return str;
    }
}

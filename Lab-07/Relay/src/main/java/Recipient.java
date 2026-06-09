public class Recipient {
    private String name;
    private String email;

    public Recipient(String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String toString(){
        String string = String.format("Name : %s , %s",name,email);
        return string;
    }
}

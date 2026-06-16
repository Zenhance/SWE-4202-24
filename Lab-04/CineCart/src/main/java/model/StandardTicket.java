package model;

public class StandardTicket extends AbstractTicket {
    private String name;

    public StandardTicket() {
        this.name = "Standard Ticket";
    }
    public StandardTicket(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }




}

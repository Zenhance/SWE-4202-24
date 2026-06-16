package model;

public class VIPTicket extends Premium {
    private String premium;
    private int id;

    public VIPTicket(String premium, int id) {
        this.premium = premium;
        this.id = id;
    }
    public String getPremium() {
        return premium;
    }
    public void setPremium(String premium) {
        this.premium = premium;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}

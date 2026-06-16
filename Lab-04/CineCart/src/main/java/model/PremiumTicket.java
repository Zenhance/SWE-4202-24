package model;

public class PremiumTicket extends AbstractTicket {
    private String premium;
    public PremiumTicket() {
        this.premium = "Premium";
    }
    public String getPremium() {
        return premium;
    }
    public void setPremium(String premium) {
        this.premium = premium;
    }
    public PremiumTicket(String premium) {
        this.premium = premium;
    }
    public PremiumTicket(String premium, int id) {
        this.premium = premium;
    }

}

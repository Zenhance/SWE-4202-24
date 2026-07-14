public abstract class Wallet {
    private String id;
    private double balance;
    private String pin;
    private boolean frozen;
    private double spentToday;
    protected Wallet(String id,double balance,String pin,boolean frozen,double spentToday){
        if (id==null||id.isBlank())
            throw new IllegalArgumentException("Wallet must have ID");
        if (balance<0)
            throw new IllegalArgumentException("Balance cannot be negative");
        if (pin==null)
            throw new IllegalArgumentException("Pin has to be entered");
    }
    public double balance() {
    }

    public void debit(double v) {
    }

    public void credit(double v) {
    }

    public boolean verifyPin(String number) {
    }

    public void freeze() {
    }
}

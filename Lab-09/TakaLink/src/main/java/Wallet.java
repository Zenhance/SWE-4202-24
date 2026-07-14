public abstract class Wallet {
    private String name;
    private double balance;
    private String PIN;
    private boolean frozenStatus;
    private double sentToday;

    public Wallet(String name, double balance, String PIN){
        this.name=name;
        this.balance=balance;
        this.PIN=PIN;

    }

}

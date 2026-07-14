public abstract class Wallet {
    private String id;
    private double balance;
    private String pin;
    private boolean frozen;
    private double spentToday;
    public Wallet(String id, double balance,String pin ,boolean frozen){
        if(id== null || id.isBlank()){
            throw new IllegalArgumentException("Invalid id");
        }
        if(balance<0.0){
            throw new IllegalArgumentException("Invalid balance");
        }
        if(pin==null){
            throw new IllegalArgumentException("Invalid pin");
        }
        this.id=id;
        this.balance=balance;
        this.pin =pin;
        this.frozen=frozen;
        this.spentToday=0;
    }
    public String getId(){
        return id;
    }
    public double getBalance(){
        return balance;
    }
    public  String getPin(){
        return pin;
    }




}


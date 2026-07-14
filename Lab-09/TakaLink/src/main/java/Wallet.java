public abstract class Wallet {

    private String name;
    private double balance;
    private String pin;
    private double senttoday;
    private boolean status;


    public Wallet(String name,double balance,String pin){

        if(name==null && name.isBlank())
            throw new IllegalArgumentException("Name isn't valid");

        if(balance<0)
            throw new IllegalArgumentException("Invalid balance");

        if(pin==null && pin.isBlank())
            throw new IllegalArgumentException("Pin isn't valid");
        this.name=name;
        this.balance=balance;
        this.pin=pin;
        this.status=false;
        this.senttoday=0.0;
    }

    public double balance(){
        return this.balance;
    }

    public void debit(double amount){
        if(amount<0.0)
            throw new IllegalArgumentException("Amount can't be negative");
        if(amount > this.balance)
            return;

        this.balance-=amount;
    }

    public void credit(double amount){
        if(amount<0.0)
            throw new IllegalArgumentException("Amount can't be negative");

        this.balance-=amount;
    }

    public boolean pinVerify(String pin){
        return this.pin.equals(pin);
    }


}
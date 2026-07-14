public abstract class Wallet {
private final String id;
private double balance;
private String pin;
    protected Wallet(String id, double balance, String pin) {
        this.id = id;
        this.balance = balance;
        this.pin = pin;
        if(id==null || id.isEmpty()){
            throw new IllegalArgumentException("id cannot be empty");
        }
        if (balance < 0.0) {
            throw new IllegalArgumentException("balance cannot be negative");
        }
        if(pin==null){
            throw new IllegalArgumentException("pin cannot be empty");
        }
        }
      public String getId() {
        return id;
      }

    }

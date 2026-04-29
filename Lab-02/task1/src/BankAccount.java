public class BankAccount {
    private String ownerName;
    private Double Balance;

    public BankAccount(String ownerName){
        this.ownerName=ownerName;
        this.Balance=0.0;
    }

    public void DepositAmount(double amount){
           if(amount<=0){
               System.out.println("Invalid Deposit Amount");
               return;
           }
           Balance+=amount;

    }


    public void WithdrawAmount(double amount){
        if(amount<=0){
            System.out.println("Invalid withdraw amount");
        }else if(amount>Balance){
            System.out.println("Insufficient fund");
        }else{
            Balance-=amount;
        }
    }


    public void PrintStatement(){
        System.out.println("Owner: "+ownerName );
        System.out.println("Balance: "+Balance);
    }


}

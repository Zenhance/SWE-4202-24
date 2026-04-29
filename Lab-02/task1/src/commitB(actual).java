class BankAccount 
  {
private String customername;
    private String balance;

    public BankAccount (String customername)
    {
this.customername= customername;
      this.balance=0;
    }

    public void deposit (double amount)
    { if (amount<=0)
    {
      System.out.println("Invalid deposited amount");
      return;}

     balance+=amount;
      
    }

    public void withdraw (double amount)
    {
     if (amount>balance)
     {

       System.out.println("Fund is not sufficient");
        return;}
      balance-=amount;
    }
    public void printStatement()
    {
     System.out.println("Customer:" + customername + "Balance: " + balance);
      
    }
    public static void main (String[] args)
    {  
      BankAccount alice = new ("Alice");
      BankAccount bob = new ("Bob");
      BankAccount abdul = new ("Abdul");
      alice.deposit(500);
      alice.withdraw(200);
      bob.deposit(800);
      bob.withdraw(300);
      abdul.deposit(1000);
      abdul.withdraw(200);

      alice.printStatement();
      bob.printStatement();
      abdul.printStatement();
      

      
    }
  }

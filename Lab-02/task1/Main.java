


public class Main

 {
  public static void main(String[]args){
  BankAccount alice=new BankAccount("Alice");
  BankAccount bob=new BankAccount("Bob");
  BankAccount tasnova=new BankAccount("Tasnova");

  alice.deposit(500);
  alice.withdraw(500);
  alice.printStatement();
  bob.deposit(500);
  bob.withdraw(500);
  bob.printStatement();
  tasnova.deposit(500);
  tasnova.withdraw(500);
  tasnova.printStatement();

  //BankAccount is a class and alice and bob are object
  //when i call alice.deposit(500) Alice's balance changes,as i have declared different object,that's ow it will understand which one to chamge.alice object is called,that's why only alice's information will change.
  // Alice-  balance after deposit: 500.0
  //         balance after withdrwal:0.0
  //         Name: Alice Balance:0.0
  //Bob-  balance after deposit: 500.0
  //         balance after withdrwal:0.0
  //         Name: Alice Balance:0.0
  //then 100 will be deposited to bob as alice and bob indicate to same object now
  }



}

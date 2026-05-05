void main() {
    BankAccount mumtahina = new BankAccount("Mumtahina");
    BankAccount nunjiba = new BankAccount("Nunjiba");

    mumtahina.deposit(10000);
    nunjiba.deposit(20000);

    mumtahina.withdraw(525);
    nunjiba.withdraw(250);

    mumtahina.printStatement();
    nunjiba.printStatement();

}

/*
(a) BankAccount is a class.Alice and Bob is an object of the BankAccount class.
(b) Only Alice's balance changes. because when we do alice.method, it knows that the
method should only change the attributes of the Alice object.In the methods one object is not connected with others.
(c) Alice:
    name = "Alice"
    balance = 0

   Bob:
     name = "Bob:
     balance = 0
(d)

 */
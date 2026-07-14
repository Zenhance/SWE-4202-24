// =====================================================================
//  THE CONTRACTOR'S CODE -- a driver that shows it "working" on the happy
//  path, and then shows the damage. Run it and watch the third line:
//  a FAILED send has already moved money.
// =====================================================================

//public class Main {
//    public static void main(String[] args) {
//        TransactionEngine engine = new TransactionEngine();
//
//        // The contractor identifies accounts by their PIN string (see find()).
//        Account alice = new Account("PERSONAL", 10_000.0, "1234");
//        Account bob   = new Account("PERSONAL", 500.0, "0000");
//        engine.addAccount(alice);
//        engine.addAccount(bob);

        // Happy path: a 1000 send settles to the paisa.
//        engine.submit(new Transaction("SEND", 1_000.0, "1234", "0000", "1234"));
//        // Damage: bob has only 500 but tries to send 5000. It WILL be rejected...
//        engine.submit(new Transaction("SEND", 5_000.0, "0000", "1234", "0000"));
//
//        System.out.println("Before: alice=" + alice.balance + " bob=" + bob.balance);
//        engine.settleBatch();
//        System.out.println("After:  alice=" + alice.balance + " bob=" + bob.balance);
//        System.out.println("Notice: bob's send was 'failed: 1', yet bob's balance is now "
//                + bob.balance + " -- the money left on a REJECTED transaction.");
//
//        // And nothing stops an outsider from simply rewriting the truth:
//        alice.balance = 1_000_000.0;
//        alice.frozen = false;
//        System.out.println("Outside code just set alice.balance = " + alice.balance);
//    }
//}

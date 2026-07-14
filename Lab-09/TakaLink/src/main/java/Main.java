
public class Main {
    public static void main(String[] args) {
        PersonalWallet alice = new PersonalWallet("alice", 10_000.0, "1234");
        PersonalWallet bob = new PersonalWallet("bob", 500.0, "0000");

        SettlementRun run = new SettlementRun();
        run.submit(new SendMoney(alice, bob, 1_000.0, "1234")); // will settle
        run.submit(new SendMoney(bob, alice, 5_000.0, "0000")); // will be rejected

        System.out.println("Before: alice=" + alice.balance() + " bob=" + bob.balance());
        SettlementReport report = run.settle();
        System.out.println("After:  alice=" + alice.balance() + " bob=" + bob.balance());

        System.out.println("Settled: " + report.settledCount()
                + "  Rejected: " + report.rejectedCount()
                + "  Total moved: " + report.totalMoved()
                + "  Total fees: " + report.totalFees());

        System.out.println("Notice: bob's send failed with "
                + "InsufficientBalanceException, and bob's balance is STILL "
                + bob.balance() + " -- unlike the contractor's version, "
                + "a rejected transaction never touched a single balance.");


        System.out.println("alice.balance is private -- outside code cannot rewrite it at all.");
    }
}
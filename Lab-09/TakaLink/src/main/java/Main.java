public class Main {
    public static void main(String[] args) throws Exception {
        PersonalWallet a = new PersonalWallet("A", 10_000.0, "1234");
        PersonalWallet b = new PersonalWallet("B", 500.0, "0000");
        AgentWallet g = new AgentWallet("G", 1_000_000.0, "9999");

        SettlementRun run = new SettlementRun();
        run.submit(new SendMoney(a, b, 1_000.0, "1234"));
        run.submit(new CashOut(a, g, 2_000.0, "1234"));

        SettlementReport report = run.settle();
        System.out.println("Settled: " + report.settledCount());
        System.out.println("Rejected: " + report.rejectedCount());
        System.out.println("Total moved: " + report.totalMoved());
        System.out.println("Total fees: " + report.totalFees());
    }
}
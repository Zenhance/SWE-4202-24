import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Acceptance tests for TakaLink. This file is the specification: it fixes the
 * exact class names, constructor shapes, method names, fees, limits, and -- for
 * every failure -- which checked exception must be thrown. You do NOT modify
 * this file. Your rebuild must make every test below pass.
 *
 * Fixed figures used throughout:
 *   - SendMoney flat fee ............ 5.0
 *   - CashOut fee ................... 1.85% of the amount
 *   - Payment / TopUp fee ........... 0.0
 *   - Personal daily sending limit .. 25,000
 *   - Agent daily sending limit ..... 500,000
 *   - Merchant ...................... may not send or cash out
 */
public class TakaLinkTest {

    private static final double EPS = 1e-6;

    // ---------------------------------------------------------------
    // The wallet guards itself
    // ---------------------------------------------------------------

    @Test
    void wallet_rejectsBadConstructionArguments() {
        assertThrows(IllegalArgumentException.class, () -> new PersonalWallet("A", -1.0, "1234"));
        assertThrows(IllegalArgumentException.class, () -> new PersonalWallet(null, 100.0, "1234"));
        assertThrows(IllegalArgumentException.class, () -> new PersonalWallet("  ", 100.0, "1234"));
        assertThrows(IllegalArgumentException.class, () -> new PersonalWallet("A", 100.0, null));
        assertThrows(IllegalArgumentException.class, () -> new AgentWallet("G", -0.01, "9999"));
    }

    @Test
    void wallet_debitAndCreditAreExactAndGuarded() throws Exception {
        PersonalWallet w = new PersonalWallet("A", 1_000.0, "1234");
        w.debit(200.0);
        assertEquals(800.0, w.balance(), EPS);
        w.credit(50.0);
        assertEquals(850.0, w.balance(), EPS);

        // a debit below zero is refused, and refused as a checked exception
        assertThrows(InsufficientBalanceException.class, () -> w.debit(10_000.0));
        // a non-positive credit is nonsense and is refused
        assertThrows(IllegalArgumentException.class, () -> w.credit(0.0));
        assertThrows(IllegalArgumentException.class, () -> w.debit(-5.0));
        // and none of the refused calls changed the balance
        assertEquals(850.0, w.balance(), EPS);
    }

    @Test
    void wallet_verifiesItsOwnPin() {
        PersonalWallet w = new PersonalWallet("A", 100.0, "4321");
        assertTrue(w.verifyPin("4321"));
        assertFalse(w.verifyPin("0000"));
    }

    // ---------------------------------------------------------------
    // Each transaction charges its own fee and moves money its own way
    // ---------------------------------------------------------------

    @Test
    void send_chargesFlatFeeToSender() throws Exception {
        PersonalWallet a = new PersonalWallet("A", 10_000.0, "1234");
        PersonalWallet b = new PersonalWallet("B", 500.0, "0000");
        new SendMoney(a, b, 1_000.0, "1234").settle();
        assertEquals(10_000.0 - 1_000.0 - 5.0, a.balance(), EPS); // debited amount + flat fee
        assertEquals(500.0 + 1_000.0, b.balance(), EPS);          // credited amount only
    }

    @Test
    void cashOut_chargesPercentAndCreditsAgent() throws Exception {
        PersonalWallet a = new PersonalWallet("A", 10_000.0, "1234");
        AgentWallet g = new AgentWallet("G", 1_000_000.0, "9999");
        new CashOut(a, g, 2_000.0, "1234").settle();
        double fee = 2_000.0 * 0.0185; // 37.0
        assertEquals(10_000.0 - 2_000.0 - fee, a.balance(), EPS);
        assertEquals(1_000_000.0 + 2_000.0 + fee, g.balance(), EPS);
    }

    @Test
    void payment_isFree() throws Exception {
        PersonalWallet a = new PersonalWallet("A", 1_000.0, "1234");
        MerchantWallet m = new MerchantWallet("M", 0.0, "5555");
        Payment p = new Payment(a, m, 300.0, "1234");
        assertEquals(0.0, p.fee(), EPS);
        p.settle();
        assertEquals(700.0, a.balance(), EPS);
        assertEquals(300.0, m.balance(), EPS);
    }

    @Test
    void topUp_isFree() throws Exception {
        PersonalWallet a = new PersonalWallet("A", 1_000.0, "1234");
        AgentWallet operator = new AgentWallet("OP", 0.0, "1111");
        TopUp t = new TopUp(a, operator, 50.0, "1234");
        assertEquals(0.0, t.fee(), EPS);
        t.settle();
        assertEquals(950.0, a.balance(), EPS);
    }

    @Test
    void transaction_rejectsBadConstructionArguments() {
        PersonalWallet a = new PersonalWallet("A", 1_000.0, "1234");
        PersonalWallet b = new PersonalWallet("B", 1_000.0, "0000");
        assertThrows(IllegalArgumentException.class, () -> new SendMoney(a, b, -5.0, "1234"));
        assertThrows(IllegalArgumentException.class, () -> new SendMoney(a, b, 0.0, "1234"));
        assertThrows(IllegalArgumentException.class, () -> new SendMoney(null, b, 5.0, "1234"));
        assertThrows(IllegalArgumentException.class, () -> new SendMoney(a, null, 5.0, "1234"));
    }

    // ---------------------------------------------------------------
    // Each failure throws its OWN checked exception (all TransactionException)
    // ---------------------------------------------------------------

    @Test
    void failure_insufficientBalance() {
        PersonalWallet a = new PersonalWallet("A", 500.0, "1234");
        PersonalWallet b = new PersonalWallet("B", 0.0, "0000");
        SendMoney s = new SendMoney(a, b, 5_000.0, "1234");
        InsufficientBalanceException e =
                assertThrows(InsufficientBalanceException.class, s::settle);
        assertTrue(e instanceof TransactionException); // catchable as the family parent
    }

    @Test
    void failure_dailyLimitExceeded() {
        PersonalWallet a = new PersonalWallet("A", 100_000.0, "1234"); // rich enough...
        PersonalWallet b = new PersonalWallet("B", 0.0, "0000");
        SendMoney s = new SendMoney(a, b, 30_000.0, "1234");           // ...but over the 25,000 limit
        assertThrows(DailyLimitExceededException.class, s::settle);
    }

    @Test
    void failure_invalidPin() {
        PersonalWallet a = new PersonalWallet("A", 10_000.0, "1234");
        PersonalWallet b = new PersonalWallet("B", 0.0, "0000");
        SendMoney s = new SendMoney(a, b, 100.0, "9999");
        assertThrows(InvalidPinException.class, s::settle);
    }

    @Test
    void failure_frozenAccount() {
        PersonalWallet a = new PersonalWallet("A", 10_000.0, "1234");
        PersonalWallet b = new PersonalWallet("B", 0.0, "0000");
        a.freeze();
        SendMoney s = new SendMoney(a, b, 100.0, "1234");
        assertThrows(FrozenAccountException.class, s::settle);
    }

    @Test
    void failure_merchantMayNotSend() {
        MerchantWallet m = new MerchantWallet("M", 10_000.0, "5555");
        PersonalWallet a = new PersonalWallet("A", 0.0, "1234");
        SendMoney s = new SendMoney(m, a, 100.0, "5555");
        assertThrows(OperationNotAllowedException.class, s::settle);
    }

    @Test
    void failure_cashOutDestinationMustBeAgent() {
        PersonalWallet a = new PersonalWallet("A", 10_000.0, "1234");
        PersonalWallet b = new PersonalWallet("B", 0.0, "0000"); // not an agent
        CashOut c = new CashOut(a, b, 1_000.0, "1234");
        assertThrows(OperationNotAllowedException.class, c::settle);
    }

    // ---------------------------------------------------------------
    // Settlement is all-or-nothing (atomic)
    // ---------------------------------------------------------------

    @Test
    void atomicity_failedTransactionMovesNoMoney() {
        PersonalWallet a = new PersonalWallet("A", 500.0, "1234");
        PersonalWallet b = new PersonalWallet("B", 700.0, "0000");

        // insufficient balance
        assertThrows(InsufficientBalanceException.class,
                () -> new SendMoney(a, b, 5_000.0, "1234").settle());
        assertEquals(500.0, a.balance(), EPS);
        assertEquals(700.0, b.balance(), EPS);

        // wrong PIN
        assertThrows(InvalidPinException.class,
                () -> new SendMoney(a, b, 100.0, "9999").settle());
        assertEquals(500.0, a.balance(), EPS);
        assertEquals(700.0, b.balance(), EPS);

        // frozen
        a.freeze();
        assertThrows(FrozenAccountException.class,
                () -> new SendMoney(a, b, 100.0, "1234").settle());
        assertEquals(500.0, a.balance(), EPS);
        assertEquals(700.0, b.balance(), EPS);
    }

    // ---------------------------------------------------------------
    // Account categories differ only where they should
    // ---------------------------------------------------------------

    @Test
    void categories_differOnlyInLimit() throws Exception {
        // A personal wallet is refused a 30,000 send (over its 25,000 limit)...
        PersonalWallet person = new PersonalWallet("P", 100_000.0, "1234");
        PersonalWallet dest1 = new PersonalWallet("D1", 0.0, "0000");
        assertThrows(DailyLimitExceededException.class,
                () -> new SendMoney(person, dest1, 30_000.0, "1234").settle());

        // ...while an agent, with the same balance, settles the same 30,000 send.
        AgentWallet agent = new AgentWallet("G", 100_000.0, "9999");
        PersonalWallet dest2 = new PersonalWallet("D2", 0.0, "2222");
        new SendMoney(agent, dest2, 30_000.0, "9999").settle();
        assertEquals(100_000.0 - 30_000.0 - 5.0, agent.balance(), EPS);
        assertEquals(30_000.0, dest2.balance(), EPS);
    }

    // ---------------------------------------------------------------
    // The run settles a mixed batch and survives failures
    // ---------------------------------------------------------------

    @Test
    void run_settlesMixedBatchAndSurvivesFailures() {
        PersonalWallet a = new PersonalWallet("A", 10_000.0, "1234");
        PersonalWallet b = new PersonalWallet("B", 500.0, "0000");
        AgentWallet g = new AgentWallet("G", 1_000_000.0, "9999");
        MerchantWallet m = new MerchantWallet("M", 0.0, "5555");

        SettlementRun run = new SettlementRun();

        Transaction good1 = new SendMoney(a, b, 1_000.0, "1234"); // fee 5, moves 1000
        Transaction good2 = new CashOut(a, g, 2_000.0, "1234");   // fee 37, moves 2000
        Transaction good3 = new Payment(a, m, 300.0, "1234");     // fee 0, moves 300
        Transaction bad1 = new SendMoney(b, a, 5_000.0, "0000");  // insufficient
        Transaction bad2 = new SendMoney(a, b, 100.0, "0000");    // wrong PIN
        Transaction bad3 = new SendMoney(m, a, 100.0, "5555");    // merchant can't send

        run.submit(good1);
        run.submit(good2);
        run.submit(good3);
        run.submit(bad1);
        run.submit(bad2);
        run.submit(bad3);

        assertEquals(6, run.pending());

        SettlementReport report = run.settle();

        assertEquals(3, report.settledCount());
        assertEquals(3, report.rejectedCount());
        assertEquals(1_000.0 + 2_000.0 + 300.0, report.totalMoved(), EPS);
        assertEquals(5.0 + 37.0 + 0.0, report.totalFees(), EPS);

        // every rejection kept its own reason
        assertTrue(report.errorOf(bad1) instanceof InsufficientBalanceException);
        assertTrue(report.errorOf(bad2) instanceof InvalidPinException);
        assertTrue(report.errorOf(bad3) instanceof OperationNotAllowedException);
        assertTrue(report.isSettled(good1));
        assertFalse(report.isSettled(bad1));

        // one bad transaction did not abort the good ones behind it
        assertEquals(10_000.0 - 1_000.0 - 5.0 - 2_000.0 - 37.0 - 300.0, a.balance(), EPS);
    }

    // ---------------------------------------------------------------
    // One slot, many forms
    // ---------------------------------------------------------------

    @Test
    void oneSlotManyForms() throws Exception {
        PersonalWallet a = new PersonalWallet("A", 10_000.0, "1234");
        PersonalWallet b = new PersonalWallet("B", 0.0, "0000");
        AgentWallet g = new AgentWallet("G", 0.0, "9999");

        Transaction t = new SendMoney(a, b, 100.0, "1234");
        ((SendMoney) t).settle();
        t = new CashOut(a, g, 200.0, "1234");
        t.settle();
        t = new Payment(a, new MerchantWallet("M", 0.0, "5555"), 50.0, "1234");
        t.settle();
        // the same slot stood in for three different kinds, each settled correctly
        assertEquals(10_000.0 - (100.0 + 5.0) - (200.0 + 200.0 * 0.0185) - 50.0, a.balance(), EPS);
    }

    // ---------------------------------------------------------------
    // Submit once, or submit repeated
    // ---------------------------------------------------------------

    @Test
    void submit_singleOrRepeated() {
        PersonalWallet a = new PersonalWallet("A", 10_000.0, "1234");
        PersonalWallet b = new PersonalWallet("B", 0.0, "0000");
        SettlementRun run = new SettlementRun();

        run.submit(new SendMoney(a, b, 10.0, "1234"));       // once
        assertEquals(1, run.pending());
        run.submit(new SendMoney(a, b, 10.0, "1234"), 3);    // three copies
        assertEquals(4, run.pending());
    }
}

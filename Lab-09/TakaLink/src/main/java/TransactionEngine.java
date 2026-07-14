// =====================================================================
//  THE CONTRACTOR'S CODE -- the God class you must REPAIR.
// =====================================================================

import java.util.ArrayList;
import java.util.List;

/**
 * Everything happens here, and every method opens with the SAME two questions:
 * "which kind of transaction?" then "which kind of account?" -- the two-level
 * if-ladder copied into process(), feeFor(), and limit(). Adding a category or
 * a transaction kind means editing all of them (and FeeBook) in step.
 *
 * Failure is reported as an int code that a caller can simply ignore, and --
 * worst of all -- process() debits the sender BEFORE it has finished checking,
 * so a transaction that is about to be rejected has already moved money.
 */

/*
public class TransactionEngine {

    List<Account> accounts = new ArrayList<>();
    List<Transaction> batch = new ArrayList<>();

    void addAccount(Account a) { accounts.add(a); }
    void submit(Transaction t) { batch.add(t); }

    Account find(String id) {
        // the contractor used the pin field as an id in the demo; good enough
        for (Account a : accounts) {
            if (a != null && a.pin.equals(id)) return a;
        }
        return null;
    }

    // 0 = OK, 1 = insufficient, 2 = over limit, 3 = bad PIN,
    // 4 = frozen, 5 = operation not allowed for this account
    int process(Transaction t) {
        Account from = find(t.fromId);
        Account to = find(t.toId);

        if (t.type == "SEND") {
            if (from.frozen) return 4;
            if (!from.pin.equals(t.pin)) return 3;
            from.balance -= t.amount;                          // money leaves NOW...
            if (from.spentToday + t.amount > limit(from)) return 2;  // ...too late
            if (from.balance - 5.0 < 0) return 1;              // ...already overdrawn
            from.balance -= 5.0;
            to.balance += t.amount;
            from.spentToday += t.amount;
            return 0;
        } else if (t.type == "CASHOUT") {
            if (from.type == "MERCHANT") return 5;             // merchants can't cash out
            if (from.frozen) return 4;
            if (!from.pin.equals(t.pin)) return 3;
            double fee = feeFor(t);                            // 0.019 here, 0.0185 in FeeBook
            from.balance -= t.amount + fee;
            if (from.balance < 0) return 1;
            to.balance += t.amount + fee;
            from.spentToday += t.amount;
            return 0;
        } else if (t.type == "PAYMENT") {
            if (from.frozen) return 4;
            if (!from.pin.equals(t.pin)) return 3;
            from.balance -= t.amount;
            if (from.balance < 0) return 1;
            to.balance += t.amount;
            return 0;
        } else if (t.type == "TOPUP") {
            if (from.frozen) return 4;
            if (!from.pin.equals(t.pin)) return 3;
            from.balance -= t.amount;
            if (from.balance < 0) return 1;
            to.balance += t.amount;
            return 0;
        }
        return 0;
    }

    double feeFor(Transaction t) {
        if (t.type == "SEND")    return 5.0;
        if (t.type == "CASHOUT") return t.amount * 0.019;      // drifts from FeeBook
        return 0.0;
    }

    double limit(Account a) {
        if (a.type == "PERSONAL") return 25000.0;
        else if (a.type == "AGENT") return 500000.0;
        else if (a.type == "MERCHANT") return 0.0;
        return 0.0;
    }

    void settleBatch() {
        for (int i = 0; i < batch.size(); i++) {
            int code = process(batch.get(i));
            if (code != 0) System.out.println("txn " + i + " failed: " + code);
        }
    }
}
*/
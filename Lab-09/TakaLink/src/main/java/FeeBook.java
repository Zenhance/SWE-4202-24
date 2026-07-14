// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

/**
 * A SECOND copy of the fee ladder, separate from the one buried inside
 * TransactionEngine.feeFor(). The two have already drifted: this one charges a
 * cash-out at 0.0185, while feeFor() charges 0.019. Nobody can say which is
 * "the" fee, and a fix to one silently leaves the other wrong.
 */
public class FeeBook {
    static double fee(String txnType, String acctType, double amt) {
        if (txnType == "SEND")     return 5.0;
        if (txnType == "CASHOUT")  return amt * 0.0185;   // ...but feeFor() says 0.019
        if (txnType == "PAYMENT")  return 0.0;
        if (txnType == "TOPUP")    return 0.0;
        return 0.0;
    }
}

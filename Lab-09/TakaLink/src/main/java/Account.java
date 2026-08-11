// =====================================================================
//  THE CONTRACTOR'S CODE -- this is what you have been handed to REPAIR.
//  It compiles and produces the right numbers on the happy path. It is
//  also the shape you must NOT keep. Read TakaLink.pdf for the six pains,
//  then rebuild against TakaLinkTest.java. Do not hand this version in.
// =====================================================================

/**
 * An anemic bag of PUBLIC fields. Anyone holding an Account can write
 * a.balance = 1_000_000, read the PIN in the clear, or set a.frozen = false
 * on a flagged account. There is no validation anywhere: a null type, a null
 * pin, and a negative balance are all perfectly legal.
 */
public class Account {
    public String type;        // "PERSONAL", "AGENT", "MERCHANT"
    public double balance;
    public String pin;
    public boolean frozen;
    public double spentToday;

    public Account(String type, double balance, String pin) {
        this.type = type;
        this.balance = balance;
        this.pin = pin;
    }
}

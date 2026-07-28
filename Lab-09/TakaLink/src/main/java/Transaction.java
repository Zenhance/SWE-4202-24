// =====================================================================
//  THE CONTRACTOR'S CODE -- part of the version you must REPAIR.
// =====================================================================

import src.main.java.Wallet;

/**
 * Another public-field bag. new Transaction("SEND", -1000, ...) is a "send"
 * that PULLS a thousand taka out of the recipient -- a theft the type system
 * waves straight through, because nothing here is ever checked.
 */
public  class Transaction {


    private Wallet payingWallet;
    private Wallet receivingWallet;
    private double amount;
    private String PIN;


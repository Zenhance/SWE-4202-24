package kenakata.settlement;

public class SellerPayout {

    private int comm;
    private int refund;
    private int out;
    private int gross;

    public boolean seller() {
        return false;
    }

    public int commission() {
        return 0;
    }

    public int refunds() {
        return 0;
    }

    public int payout() {
        return 0;
    }

    public int grossSales() {
        return 0;
    }


    void setComm(int comm) {
        this.comm = comm;
    }

    void setRefund(int refund) {
        this.refund = refund;
    }

    void setOut(int out) {
        this.out = out;
    }

    void setGross(int gross) {
        this.gross = gross;
    }
}

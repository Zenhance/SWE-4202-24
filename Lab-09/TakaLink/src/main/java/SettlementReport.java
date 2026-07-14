public class SettlementReport {

    public static int settleCount = 0;
    public static int rejectCount = 0;
    public static int moved = 0;
    public static double fees = 0.0;
    public static boolean settled;

    public static void settlePlus(){settleCount++;}

    public int settledCount(){return settleCount;}

    public int rejectedCount(){return rejectCount;}

    public int totalMoved(){return 0;}

    public double totalFees(){return 0;}

    public boolean isSettled(Transaction t){return false;}

    public Exception errorOf(Transaction t){return null;}
}

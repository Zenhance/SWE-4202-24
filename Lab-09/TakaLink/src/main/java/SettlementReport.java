public class SettlementReport {

    public static int settleCount = 0;
    public static int rejectCount = 0;
    public static int moved = 0;
    public static double fees = 0.0;
    public static boolean settled;

    //public static void settlePlus(){settleCount++;}

    public static int settledCount(){return settleCount;}

    public static int rejectedCount(){return rejectCount;}

    public static int totalMoved(){return 0;}

    public double totalFees(){return 0;}

    public boolean isSettled(Transaction t){return t.settled;}

    public Exception errorOf(Transaction t){return null;}
}

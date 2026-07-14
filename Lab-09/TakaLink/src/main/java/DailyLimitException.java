public class DailyLimitException extends TransactionException
{
    public DailyLimitException()
    {
        super("Daily Limit Exceeded");
    }
}

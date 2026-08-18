public class TimeCalculation
{
    private int currentTime;

    public TimeCalculation()
    {
        currentTime=0;
    }

    public int getCurrentTime()
    {
        return currentTime;
    }

    public void timePassed(int hours)
    {
        currentTime=currentTime+hours;
    }
}
public class Parking
{
    private int collected;
    private int refused;

    public Parking(int collected, int refused)
    {
        collected=0;
        refused=0;
    }

    public int getCollected()
    {
        return collected;
    }

    public int getRefused()
    {
        return refused;
    }

    public void addCollection(int amount)
    {
        collected=collected+amount;
    }

    public void addRefusal()
    {
        refused++;
    }
}
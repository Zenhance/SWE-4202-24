public class Vehicle
{ public enum Category
{
    BIKE, CAR, TRUCK
}
    public enum DiscountScheme
    {
        NONE, STUDENT, WEEKEND
    }
    private String numberPlate;
    private int entranceTime;
    private Category category;
    private DiscountScheme scheme;
    private Slot slot;

    public Vehicle(String numberPlate, int entranceTime, Category category, DiscountScheme scheme, Slot slot)
    {
        this.numberPlate = numberPlate;
        this.entranceTime = entranceTime;
        this.category = category;
        this.scheme = scheme;
        this.slot = slot;
    }

    public String getNumberPlate()
    {
        return numberPlate;
    }

    public int getEntranceTime()
    {
        return entranceTime;
    }

    public Slot getSlot()
    {
        return slot;
    }

    public void setSlot(Slot slot)
    {
        this.slot = slot;
    }

    public int stayHours(int presentTime)
    {
        return presentTime-entranceTime;
    }
    public Category getCategory()
    {
        return category;
    }

    public DiscountScheme getScheme()
    {
        return scheme;
    }
}
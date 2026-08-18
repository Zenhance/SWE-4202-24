public class Slot
{
    private Type type;
    private Vehicle vehicle;

    public Slot(Type type)
    {
        this.type = type;
    }

    public int firstHourRate()
    {
        return switch(type)
        {
            case BIKE->10;
            case REGULAR->30;
            case LARGE->50;
        };
    }

    public int furtherHourRate()
    {
        return switch(type)
        {
            case BIKE->5;
            case REGULAR->20;
            case LARGE->40;
        };
    }

    public int surcharge()
    {
        return switch(type)
        {
            case BIKE->0;
            case REGULAR->15;
            case LARGE->25;
        };
    }

    public Type getType()
    {
        return type;
    }

    public Vehicle getVehicle()
    {
        return vehicle;
    }

    public boolean isFreeSlot()
    {
        return vehicle==null;
    }

    public void free()
    {
        if(vehicle != null)
        {
            vehicle.setSlot(null);
        }
        vehicle=null;
    }
}
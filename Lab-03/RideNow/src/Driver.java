class Driver
{
    private int id;
    private String name;
    private String licencePlate;
    private boolean isAvailable;

    public Driver(int id, String name, String licencePlate)
    {

    }

    public Driver(int id, String name, String licencePlate, boolean isAvailable)
    {

    }

    public void setAvailable(boolean available)
    {
        this.isAvailable=available;
    }

    public String toString()
    {
        String situation="[AVAILABLE]";
        if(isAvailable)
        {
            situation="[AVAILABLE]";
        }
        else
        {
            situation="[BUSY]";
        }
        return "Driver["+id+"]"+" "+name+" "+"("+licencePlate+")"+situation;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getLicencePlate()
    {
        return licencePlate;
    }

    public boolean isAvailable()
    {
        return isAvailable;
    }
}
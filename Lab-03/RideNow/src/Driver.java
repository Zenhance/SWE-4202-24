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

    }

    public String toString()
    {
        return "Driver[7] Bob (DHA-1234) [AVAILABLE]";
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLicencePlate()
    {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate)
    {
        this.licencePlate = licencePlate;
    }

    public boolean isAvailable()
    {
        return isAvailable;
    }
}
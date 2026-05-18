public class Driver
{
    private  int id;
    private String name;
    private String licensePlate;
    boolean isAvailable;
    public Driver (int id, String name, String licensePlate )
    {

        this.id=id;
        this.name=name;
        this.licensePlate=licensePlate;
    }

    public Driver (int id, String name, String licensePlate, boolean isAvailable)
    {
        this.id=id;
        this.name=name;
        this.licensePlate=licensePlate;
        this.isAvailable=isAvailable;
    }

    public int getId()
    {

        return id;
    }


    public String getName()
    {
        return name;
    }
    public String getLicensePlate()
    {

        return  licensePlate;
    }

    public boolean isAvailable()
    {
        return isAvailable;

    }

    void setAvailable (boolean available)
    {

        this.isAvailable=available;
    }
    public String toString()
    { String status;
        if (isAvailable){ status= "AVAILABLE";}
        else {status= "BUSY";}
        return String.format (" Driver[%d] %s (%s) [%s]",
                id, name, licensePlate, status);






    }

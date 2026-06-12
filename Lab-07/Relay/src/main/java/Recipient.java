public class Recipient
{
    private String name;
    private String address;

    public Recipient(String name, String address)
    {
        if(name==null || name.isBlank())
        {
            throw new IllegalArgumentException("Name Needed");
        }
        if(address==null || address.isBlank())
        {
            throw new IllegalArgumentException("Address Needed");
        }
        this.name = name;
        this.address = address;
    }

    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }
}
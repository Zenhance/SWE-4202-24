package catalog;

public class Seller {
    private String name;
    public Seller(String name)
    {
        if(name==null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null");
        this.name=name;
    }

    public String name()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return name;
    }
}

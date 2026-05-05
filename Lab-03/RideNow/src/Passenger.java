class Passenger
{
    private int id;
    private String name;
    private double rating;

    public Passenger(int id, String name, double rating)
    {
        this.id=id;
        this.name=name;
        this.rating=rating;
    }

    public Passenger(int id, String name)
    {

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

    public double getRating()
    {
        return rating;
    }

    public void setRating(double rating)
    {
        this.rating = rating;
    }

}
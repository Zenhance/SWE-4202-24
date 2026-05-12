package model;
class Movie
{
    private int id;
    private String title;
    private String rating;
    private int durationMin;
    private double basePrice;

    public Movie(int id, String title, String rating, int durationMin, double basePrice)
    {
        this.id=id;
        this.title=title;
        this.rating=rating;
        this.durationMin=durationMin;
        this.basePrice=basePrice;
    }

    public int getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public String getRating()
    {
        return rating;
    }

    public int getDurationMin()
    {
        return durationMin;
    }

    public double getBasePrice()
    {
        return basePrice;
    }
}

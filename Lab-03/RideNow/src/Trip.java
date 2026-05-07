class Trip
{
    private Passenger passenger;
    private Driver driver;
    private Location from;
    private Location to;
    private double baseFare;
    private boolean completed;

    public Trip(Passenger passenger, Driver driver, Location from, Location to, double baseFare)
    {
        this.passenger=passenger;
        this.driver=driver;
        this.from=from;
        this.to=to;
        this.baseFare=baseFare;

        completed=false;

        driver.setAvailable(false);
    }

    public double calculateFare()
    {
        double fare=0;
        fare=baseFare+(15.0*getDistance());
        return fare;
    }

    public void completeTrip()
    {
        completed=true;
        driver.setAvailable(true);
    }

    public double getDistance()
    {
        return from.distanceTo(to);
    }

    public String getSummary()
    {
        String situation;
        if(completed)
        {
            situation="COMPLETED";
        }
        else
        {
            situation="IN PROGRESS";
        }
        return "Trip Summary\n"+"Passenger : "+passenger.getName()+"\n"+"Driver : "+"Driver["+driver.getId()+"]"+" "+driver.getName()+" "+"("+driver.getLicencePlate()+")"+"\n"+
                "From : "+from.toString()+"\n"+"To : "+to.toString()+"\n"+
                "Distance : "+String.format("%.2f",getDistance())+" km\n"+
                "Fare : BDT "+String.format("%.2f",calculateFare())+"\n"+
                "Status : "+situation;
    }

    public Passenger getPassenger()
    {
        return passenger;
    }

    public Driver getDriver()
    {
        return driver;
    }

    public Location getFrom()
    {
        return from;
    }

    public Location getTo()
    {
        return to;
    }

    public double getBaseFare()
    {
        return baseFare;
    }

    public boolean isCompleted()
    {
        return completed;
    }
}
public class Trip
  {
   private passenger passenger;
    private Driver driver;
    private location from;
    private location to;
    private double baseFare;
    private boolean completed;
public Trip (passenger passenger, Driver driver, location from, location to, double baseFare)
    {
this.passenger=passenger;
      this.driver=driver;
      this.from=from;
      this.to=to;
      this.baseFare=baseFare;
      this.completed=false; 
       driver.setAvailable= false; //driver variable inside trip class calls the setAvailable method that we defined inside driver and sets it to false


        public passenger getPassenger()
          {  return this.passenger; 
          }
       public passenger getDriver()
         {
         return this.driver;
         }
      public location getFrom()
        {
        return from;
        }
      public location getTo()
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
      public double getDistance()
        {
        from.distanceTo(to); 
 /* 
 here, we are calling the distanceTo method that we defined inside location class
 to calculate the distance between from and to, here according to our syntax, from is the caller object and 
 to is being passed as the argument, so "this" keyword inside distanceTo keyword uses the value returned by from and "other"
uses the value returned by to 
 */       }
      public double calculateFare()
        {
        return baseFare + (15*getDistance());
        }
      public void completeTrip()
        {
           this.completed=true;
        driver.setAvailable(true);
        
        }
      public String getSummary()
        {

        return "Trip Summary\n"
                + "Passenger : " + passenger.getName() + "\n"
                + "Driver    :" + driver.getName() + (" + driver.getLicensePlate()+ " )\n"
                + "From      : " + from.toString() + " \n" 
                + "To        :  " + to.toString() + "\n"
                + "Distance  : " + String.format("%.2f", getDistance())" km \n" 
                +" Fare      :BDT " + String.format(" %.2f", getDistance()+ )" \n"                                                           
                + "Status    :" +status;                               
        }
    }













    
  }

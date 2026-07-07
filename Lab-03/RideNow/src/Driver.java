public class Driver {
   private int id;
   private String name;
   private String licencePlate;
   private boolean isAvailable;

   public Driver(int id, String name, String licencePlate, boolean isAvailable){
       this.id=id;
       this.name=name;
       this.licencePlate=licencePlate;
       this.isAvailable=isAvailable;


   }
   public Driver(int id, String name, String licencePlate){
       this.id=id;
       this.name=name;
       this.licencePlate=licencePlate;
       this.isAvailable=true;

   }
   public int getId(){
       return this.id;
   }
   public String getName(){
       return this.name;
   }
   public String getLicencePlate(){
       return this.licencePlate;
   }
   public boolean isAvailable(){
       return this.isAvailable;
   }
   public void setAvailable(boolean available){
       this.isAvailable=available;
   }
   public String toString(){
       if(isAvailable){
           return "Driver["+this.id+"] "+this.name+" ("+this.licencePlate+") [AVAILABLE]";
       }
       else{
           return "Driver["+this.id+"] "+this.name+" ("+this.licencePlate+") [BUSY]";
       }
   }



}

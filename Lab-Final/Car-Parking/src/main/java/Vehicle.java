public  class Vehicle {
     private Type type;
     private Scheme scheme;
     private int entry;
     private String plate;
     Vehicle(Type type,Scheme scheme,int entry,String plate){
         this.type=type;
         this.scheme=scheme;
         this.entry=entry;
         this.plate=plate;
     }

    public int getEntry() {
        return entry;
    }

    public Scheme getScheme() {
        return scheme;
    }

    public String getPlate() {
        return plate;
    }

    public Type getType() {
        return type;
    }
}

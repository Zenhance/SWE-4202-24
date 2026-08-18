public abstract class Vehicle {
    private final String registration;
    private final String pass;
    private String assignedSlot;
    private int entryTime;
    private boolean oversized;
    public Vehicle(String registration, String pass) {
        this.registration = registration;
        this.pass = pass;
    }
    public String getRegistration(){
        return registration;
    }
    public String getPass(){
        return pass;
    }
    public String getAssignedSlot(){
        return assignedSlot;
    }
    public void setAssignedSlot(String assignedSlot){
        this.assignedSlot = assignedSlot;
    }
    public int getEntryTime(){
        return entryTime;
    }
    public void setEntryTime(int entryTime) {
        this.entryTime = entryTime;
    }



}

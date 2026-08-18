public abstract class Slot {
    protected boolean student=false;
    protected boolean weekend=false;
    protected boolean surchargable=false;
    protected int earnings=0;
    private int MAXSTAY;
    protected static int count=0;
    private int refused=0;
    protected int PASSTIME;
    private String numPlate;
    private String Scheme;
    protected int reglarBill=0;
    protected int bikeBill=0;
    protected int truckBill=0;



    Slot(String numPlate){
        this.numPlate=numPlate;
    }
    Slot(String numPlate, String Scheme){
        this.numPlate=numPlate;
        this.Scheme=Scheme;
        if(Scheme.equals(student)){
            student=true;
        } else if (Scheme.equals(weekend)) {
            weekend=true;

        }
        count++;
    }

    public void setMAXSTAY(int MAXSTAY) {
        this.MAXSTAY = MAXSTAY;
    }

    public void setPASSTIME(int PASSTIME) {
        this.PASSTIME = PASSTIME;
    }
    public void setSurchargable(){
        surchargable=true;
    }
    public void refused(){
        refused++;
    }
    public int getSlot(){
        return count;
    }
    protected abstract void fee();
    protected abstract void free();
    protected abstract void leave();
    public int getEarnings(){
        return earnings=earnings+bikeBill+reglarBill+truckBill;
    }

}

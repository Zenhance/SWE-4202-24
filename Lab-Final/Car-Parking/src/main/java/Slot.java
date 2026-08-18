public abstract class Slot {
    protected boolean student=false;
    protected boolean weekend=false;
    protected int earnings=0;
    private int MAXSTAY;
    private static int count=0;
    private int refused=0;
    protected int PASSTIME;
    private String numPlate;
    private String Scheme;

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
    public void refused(){
        refused++;
    }
    public int getSlot(){
        return count;
    }
    protected abstract int fee();
}

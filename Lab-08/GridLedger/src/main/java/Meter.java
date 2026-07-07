public class Meter {
    private int currentReading;
            private int previousReading;
            public Meter(int currentReading,int previousReading){
                this.currentReading=currentReading;
                this.previousReading=previousReading;
            }
            public int getPreviousReading(){
                return previousReading;
            }
            public void setPreviousReading(int previousReading){
                this.previousReading=previousReading;
            }
            public int getCurrentReading(){
                return currentReading;
            }
            public void setCurrentReading(int currentReading){
                this.currentReading=currentReading;
            }
public int getUnits() {
    return currentReading - previousReading;
}
    }

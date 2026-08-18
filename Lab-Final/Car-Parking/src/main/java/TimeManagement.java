public class TimeManagement {
    private int currentTime;

    public TimeManagement(){
        currentTime=0;
    }
    public int getCurrentTime(){
        return currentTime;
    }
    public void passTime(int hours){
        currentTime+=hours;
    }
}

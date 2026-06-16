public class Outbox {
    Message[] notices;
    int count=0;

    public float totalCost() {
        return 0.0f;
    }

    public void enqueue(Message notice){
        notices[count++]=notice;
    }
    public void enqueue(Message notice, int repeat){
        for(int i=0;i<repeat;i++){
            notices[count++]=notice;
        }
    }
    public String flush() {
        return null;
    }

    public int size() {
        return 0;
    }
}

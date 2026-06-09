public class Outbox {
    private Notice[] notices;
    private int count;
    public Outbox(){
        notices= new Notice[100];
        count = 0;
    }
    public void queue(Notice notice){
        notices[count++]=notice;
    }
}

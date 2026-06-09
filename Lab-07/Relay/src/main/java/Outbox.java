public class Outbox {
    private Notice[] notices;
    private int count;
    public Outbox(){
        notices=new Notice[100];
        count=0;
    }
    public void queue(Notice n){
       notices[count++]=n;
    }
    public void queue(Notice n,int repeat){
        for(int i=0;i<repeat;i++){
            notices[count++]=n;
        }
    }
    public int waitingCount(){
        return count;
    }

}

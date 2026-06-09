public class Outbox {
    private Message[] notices;
    private int count;
    public Outbox(){
        notices=new Message[100];
        count=0;
    }
    public void enqueue(Message n){
       notices[count++]=n;
    }
    public void enqueue(Message n, int repeat){
        for(int i=0;i<repeat;i++){
            notices[count++]=n;
        }
    }
    public int waitingCount(){
        return count;
    }
    public double totalCost(){
        double total=0;
        for(int i=0;i<count;i++){
            total+=notices[i].cost();
        }
        return total;
    }
    public String flush(){
        String log="";
        for(int i=0;i<count;i++){
            log+=notices[i].deliver()+ "\n";
        }
        count=0;
        return log;
    }
}

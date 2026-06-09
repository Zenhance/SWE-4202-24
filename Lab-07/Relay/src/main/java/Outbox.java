public class Outbox {
    private Message[] messages;
    private int count;

    public Outbox(){
        messages=new Message[100];
        count=0;
    }

    public void enqueue(Message notice){
        messages[count]=notice;
        count++;
    }

    public void enqueue(Message notice,int repeat){
        for(int i=0;i<repeat;i++){
            enqueue(notice);
        }
    }
    public int size(){
        return count;
    }
    public double totalCost(){
        double total=0.0;
        for(int i=0;i<count;i++){
            total+=messages[i].cost();
        }
        return total;
    }

    public String flush(){
        String log= "";

        for(int i=0;i<count;i++){
            log +=messages[i].deliver();

            if(i<count-1){
                log+="\n";
            }
        }
        count=0;
        return log;
    }
}

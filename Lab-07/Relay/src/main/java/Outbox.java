public class Outbox {
    private Message[] message= new Message[100];
    private int cnt=0;

    public void enqueue(Message m){
        this.message[cnt++]=m;
    }

    public int size(){
        return cnt;
    }

    public double totalCost(){
        double cost=0;
        for(int i=0;i<cnt;i++){
            cost+=message[i].cost();
        }
        return cost;
    }

    public String flush(){
        String queue = "";
        for(int i=0;i<cnt;i++){
            queue+=message[i].deliver();
        }
        return queue;
    }

    public void enqueue(Message m,int a){
        for(int i=0;i<a;i++){
            enqueue(m);
        }
    }
}

public class Outbox {
    private Message[] messages= new Message[50];
    private int count=0;
    public Outbox() {
    }
    public void enqueue(Message type){

        messages[count]=type;
        count++;
    }
    public void enqueue(Message type,int counts){
        for(int i=0;i<counts;i++){
            messages[count]=type;
            count++;
        }
    }
    public String flush(){

        return null;
    }
    public int size() {
        return count;
    }
    public double totalCost(){
        double total=0;
        for(int i=0; i<count; i++){
            total+=messages[i].cost();
        }
        return total;
    }




}
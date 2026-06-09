public class Outbox {
    private Message[] msgs = new Message[20];
    private int count = 0;
    private double totalCost = 0;

    public void enqueue(Message m){
        this.msgs[count] = m;
        count++;
    }

    public void enqueue(Message m, int qty){
        for (int i = 0; i < qty; i++)
        {
            enqueue(m);
        }
    }

    public int size(){return count;}

    public double totalCost(){
        double total= 0;
        for (int i = 0; i < count; i++)
        {
            total += msgs[i].cost();
        }

        return total;
    }

    public String flush(){
        String res = "";
        for (int i = 0; i < count; i++){
            res = res + msgs[i].deliver();
        }
        return res;
    }
}

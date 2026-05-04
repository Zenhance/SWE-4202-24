public class StudentQueue {
    String[] name = new String[1000];
    float[] mark = new float[1000];
    int students=1000;
    int count;

    public void enqueue(String name,float mark) {
        if(count==students) {
            System.out.println("SORRY! The queue is full");
        }

        this.name[count]=name;
        this.mark[count]=mark;
        count++;
    }

    public void dequeue() {
        if(count==0) {
            System.out.println("Error! The queue is empty");
        }

        count--;
        for(int i=0;i<count;i++) {
            this.name[i]=name[i+1];
            this.mark[i]=mark[i+1];
        }
    }

    public void front() {
        System.out.println(name[0]);
        System.out.println(mark[0]);
    }
}

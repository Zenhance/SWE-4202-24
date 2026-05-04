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
}

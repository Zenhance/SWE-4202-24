public class StudentQueue {

    private String[] name=new String[50];
    private int[] marks=new int[50];
    private int cnt=0;

    public void enqueue(String name, int marks) {
        if (cnt>50){
            System.out.println("Queue is full");
            return;
        }
        this.name[cnt] = name;
        this.marks[cnt] = marks;
        cnt++;
    }

    public void dequeue(){
        if(cnt==0){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Dequeued: "+name[0]+" "+marks[0]);
        for(int i=0;i<cnt-1;i++){
            name[i]=name[i+1];
            marks[i]=marks[i+1];
        }
        cnt--;

    }


}

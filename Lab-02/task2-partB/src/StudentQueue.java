public class StudentQueue {
    private Student[] queue_list;
    private int capacity;
    private int count;

    public StudentQueue(int capacity){
        queue_list=new Student[capacity];
        this.capacity=capacity;
        int count=0;

    }


    public void enqueue(Student s){
        if(count==capacity){
            System.out.println("QUEUE IS FULL");
        }
        queue_list[count]=s;
        count++;
    }


    public void dequeue(){
        if(count==0){
            System.out.println("ERROR");
            return;
        }

        for(int i=0; i<=count; i++){
            queue_list[i]=queue_list[i+1];
        }
        count--;
    }

    public Student front(){
        if(count==0){
            System.out.println("ERROR");
            return null;
        }
        return (queue_list[0]);
    }

    public void Display(){
        if(count==0){
            System.out.println("ERROR");
        }

        for(int i=0; i<=count; i++){
            System.out.println(queue_list[i].name+"---"+queue_list[i].mark);
        }
    }
}

//this is the queue one, this was much more similar to the stack

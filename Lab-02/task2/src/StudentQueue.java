public class StudentQueue {
    String[] names;
    int[] marks;
    int count;
    //constructor-initialize
    StudentQueue(String[] name, int[] mark){
        this.names = name;
        this.marks = mark;
        this.count = 0;
    }
    public void enqueue(String name, int mark){
        if(count==100) {
            System.out.println("ERROR!!QUEUE IS FULL!!");
            return;
        }
        names[count] = name;
        marks[count] = mark;
        count++;
    }
    public void dequeue(){
        if(count==0){
            System.out.println("ERROR!! QUEUE IS EMPTY!!");
            return;
        }
        for(int i=0;i<count-1;i++){
            names[i] = names[i+1];
            marks[i] = marks[i+1];
        }
        count--;
    }
    public void front(){
        System.out.println("Name:"+names[0]+" "+"Marks:"+marks[0]);
    }
    public void display(){
        for(int i=0;i<count;i++) {
            System.out.println("Name:"+names[i]+" "+"Marks:"+marks[i]);
        }
    }
}
/*
a.
b. As the array and count are private, bringing any change to them from outside is not possible and hence each class uses them to enforce various methods using their own features while maintaining their same initial structure.
 */

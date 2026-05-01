public class StudentQueue {
    String[] names;
    double[] marks;
    int count = 0;

    StudentQueue(String[]names, double[] marks){
        this.names = names;
        this.marks = marks;
    }
    public void enqueue (String name,double mark){
        if (count == names.length) {
            System.out.println("Queue is full");
            return;
        }
        this.names[count] = name;
        this.marks[count] = mark;
        count++;
    }
    public void dequeue () {
        if (count == 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Name:" + names[0] + " Marks: " + marks[0]);
        for (int i = 0; i < count - 1; i++) {
            names[i] = names[i + 1];
            marks[i]=marks[i+1];
        }
        count--;
    }
    public void front () {
        if(count==0){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Name: " + names[0] + " Marks: " + marks[0]);
    }
    public void display () {
        for (int i = 0; i < count; i++) {
            System.out.println("Name:" + names[i] + " Marks" + marks[i]);
        }
    }
}
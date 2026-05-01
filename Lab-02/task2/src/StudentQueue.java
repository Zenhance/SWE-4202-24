/*
a.If there are 50 students in the queue and dequeue is called 45 times,
many elements need to shift repeatedly.This causes a large number of
element movement because after each removall all remaining student move left.

b.Keeping arrays private protect the data from direct modification.
This allow the class to control how values are added or removed.
*/

class StudentQueue {
    private String[] studentNames;
    private int[] studentMarks;
    private int total;

    public StudentQueue(int size) {
        studentNames=new String[size];
        studentMarks=new int[size];
        total=0;
    }
    public void enqueue(String name,int mark) {
        if (total==studentNames.length) {
            System.out.println("queue full");
            return;
        }

        studentNames[total]=name;
        studentMarks[total]=mark;
        total++;

        System.out.println(name+"inserted");
    }

    public void dequeue() {
        if (total==0) {
            System.out.println("no students in queue");
            return;
        }

        System.out.println("Deleted:" + studentNames[0] + "(" + studentMarks[0] + ")");

        for (int i=0;i<total-1;i++) {
            studentNames[i]=studentNames[i + 1];
            studentMarks[i]=studentMarks[i + 1];
        }
        total--;
    }

    public void front() {
        if (total==0) {
            System.out.println("queue empty");
            return;
        }

        System.out.println("First Student: " + studentNames[0] + " (" + studentMarks[0] + ")");
    }

    public void display() {
        if (total == 0) {
            System.out.println("queue empty");
            return;
        }

        System.out.println("queue list:");

        for(int i=0;i<total;i++) {
            System.out.println(studentNames[i] + " : " + studentMarks[i]);
        }
    }
}

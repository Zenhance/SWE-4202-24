/*
a.for each call of dequeue,all remaining elements are shifted one position to the left
if there are 50 students, first it shifts 49 elements,then 48,then 47 and so one,
so,total shifts or moves will be arount 1215.

b.If the array is private,it prevents outside code from accessing it's data,so,each classes
(stack,queue,list) can enforce different rules while using the same array.
*/

public class StudentQueue {

       private String[] names = new String[50];
       private int[] marks = new int[50];
       private int count=0;


public void enqueue(String n,int mark){

               if(count >=50){

                   System.out.println("The queue is full");
                   return;
               }

             names[count] = n;
             marks[count] = mark;
             System.out.println("Adding to the queue: " +names[count] + " (" + marks[count] + ")");
             count++;
}


public void dequeue() {

    if (count == 0) {

        System.out.println("The queue is empty");
        return;
    }

    System.out.println("Removing from the queue: " + names[0] + " (" + marks[0] + ")");

    for (int i = 0; i < count - 1; i++) {

        names[i] = names[i + 1];
        marks[i] = marks[i + 1];
    }

        names[count - 1] = null;
        marks[count - 1] = 0;

        count--;
    }


public void front(){


        if(count == 0){

            System.out.println("Queue is empty!");
            return;
        }

        System.out.println("Front: " + names[0] + " (" + marks[0] + ")");
    }

public void display(){
        System.out.println("The queue:");
        for(int i=0;i<count;i++){

            System.out.println(i + " " + names[i] + " " + marks[i]);
        }
    }
}



public class StudentQueue {

       private String[] names = new String[50];
       private int[] marks = new int[50];
       private int count=0;


public void enqueue(String n,int mark){

               if(count >=50){

                   System.out.println("The queue is full");
                   return;
               }
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

        names[count - 1] = null;
        marks[count - 1] = 0;

        count--;
    }


public void front(){


        if(count == 0){

            System.out.println("Queue is empty!");
            return;
        }

        System.out.println("Front: " + names[0] +  " (" + marks[0] + ")");
    }

public void display(){
        System.out.println("The queue:");
        for(int i=0;i<count;i++){

            System.out.println(i + " " + names[i] + " " + marks[i]);
        }
    }







}



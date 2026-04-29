public StudentQueue {
    String[] names;
    double[] marks;
    int count = 0;

    StudentQueue(String[]names. double[] marks){
        this.names = names;
        this.marks = marks;
    }
    public void enqueue (String names,double marks){
        if (count == 500) {
            System.out.println("Stack is full");
            return;
        }
        names[count] = names;
        marks[count] = marks;
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
        }
        count--;
    }

}
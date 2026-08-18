public class StudentQueue {
    private Student[] arr = new Student[5];
    private int c = 0;

    public void enqueue(String name, double mark) {
        if (c == arr.length) {
            System.out.println("Queue is full");
            return;
        }
        arr[c] = new Student(name, mark);
        c++;
    }

    public void dequeue() {
        if (c == 0) {
            System.out.println("Queue is empty");
            return;
        }

        arr[0].print();

        for (int i = 1; i < c; i++) {
            arr[i - 1] = arr[i];
        }

        c--;
    }

    public void front() {
        if (c == 0) {
            System.out.println("Queue is empty");
            return;
        }
        arr[0].print();
    }

    public void display() {
        for (int i = 0; i < c; i++) {
            arr[i].print();
        }
    }
}


//a.If we dequeue 45 times from 50 students, the total number of moves is roughly 49 + 48 + ... + 5, which is over 1000 moves.
//b.
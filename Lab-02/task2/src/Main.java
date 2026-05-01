import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("=====Stack=====");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter How many student to Enter : ");

        int cap = sc.nextInt();
        sc.nextLine();
        StudentStack stack = new StudentStack(cap);
        for(int i =0; i<cap; i++){
            System.out.print("Enter Name: ");
            String tempName = sc.nextLine();

            System.out.printf("Enter %s's Marks: ", tempName);
            int tempMarks = sc.nextInt();
            sc.nextLine();
            stack.push(tempName, tempMarks);
        }

        System.out.println("1. Pop;");
        System.out.println("2. Peek;");
        System.out.println("3. Display;");
        System.out.println("0. End stack and continue to Queue;");
        for(int i =0 ;; i++){
            int choice = sc.nextInt();
            System.out.println("1. Pop;");
            System.out.println("2. Peek;");
            System.out.println("3. Display;");
            System.out.println("0. End stack and continue to Queue;");
            if(choice == 1)
                stack.pop();
            else if(choice == 2)
                stack.peek();
            else if(choice == 3)
                stack.display();
            else if(choice == 0)
                break;
            else
                System.out.println("Wrong input try again:)");
            sc.nextLine();
        }

        System.out.println("Stack checking end here;");

        System.out.println("=====Queue=====");
        System.out.print("Enter How many student to Enter : ");

        int capQ = sc.nextInt();
        sc.nextLine();

        StudentQueue queue = new StudentQueue(capQ);

        for(int i = 0; i < capQ; i++){
            System.out.print("Enter Name: ");
            String tempName = sc.nextLine();

            System.out.printf("Enter %s's Marks: ", tempName);
            double tempMarks = sc.nextDouble();
            sc.nextLine();

            queue.enqueue(tempName, tempMarks);
        }

        System.out.println("1. Dequeue;");
        System.out.println("2. Front;");
        System.out.println("3. Display;");
        System.out.println("0. End program;");

        for(int i = 0; ; i++){
            int choice = sc.nextInt();

            System.out.println("1. Dequeue;");
            System.out.println("2. Front;");
            System.out.println("3. Display;");
            System.out.println("0. End program;");

            if(choice == 1)
                queue.deQueue();
            else if(choice == 2)
                queue.front();
            else if(choice == 3)
                queue.display();
            else if(choice == 0)
                break;
            else
                System.out.println("Wrong input try again:)");

            sc.nextLine();
        }
        System.out.println("The End!!!");



    }
}

        /*
        Easy Input:
10
Alice
85
Bob
90
Charlie
78
David
88
Eve
92
Frank
75
Grace
89
Hannah
91
Ibrahim
83
Jack
87
         */
/*
a. dequeue always shifts the entire remaining array one step to the left. If the queue
holds 50 students and you dequeue 45 times, roughly how many individual element
moves does that require in total?
--Ans--Each dequeue shifts all remaining elements left by one.
Starting with 50 students, the moves for 45 dequeues are:
    49 + 48 + 47 + ... ... + 5
    As first dequeue shifts 49 , second shifts 48 and so on.
The structure is like an arithmetic series .
Here, number of terms = 45
Midpoint = (49 + 5) / 2 = 27
Total moves = 45 * 27 = 1215 moves



b. You have now written three classes — StudentList, StudentStack, and StudentQueue
— all using the same private array and count. The only real difference is which meth-
ods are available to outside code. In one sentence, explain why hiding the array as
private makes this possible.
--Ans--Internal storage gets hidden when we make the array private and so only 
the public methods can be used by outside code , allowing different classes to use the same 
array structure behaving differently.


*/
public class StudentQueue {

}

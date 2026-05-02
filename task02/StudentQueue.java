/*
 * StudentQueue.java
 *
 * Part C answers (StudentQueue):
 *
 * a) every time you dequeue, you shift all remaining elements one step left.
 *    so the 1st dequeue shifts 49, the 2nd shifts 48, all the way down to the
 *    45th which shifts 5. thats 49+48+47...+5 = around 1175 total moves.
 *
 * b) because the array is private, outside code can only use it through the
 *    methods we choose to expose. this means we can give StudentStack only
 *    push/pop rules and StudentQueue only enqueue/dequeue rules, even though
 *    the underlying array is the same idea in both.
 */


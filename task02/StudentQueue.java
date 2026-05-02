/*
 * StudentStack.java
 *
 * Part C answers (StudentStack):
 *
 * a) since push and pop only increment or decrement count without moving any
 *    elements around, the speed is exactly the same whether there are 5 or 50
 *    students. it always does just one step regardless of how big the stack is.
 *
 * b) no they cant interfere. even though both classes have a field named count,
 *    each object gets its own separate copy of it in memory. so changing one
 *    objects count doesnt affect the other at all.
 */
#include <stdio.h>
#include <string.h>

/*
Student Record System  
Core Idea:
- We use TWO parallel arrays:
    names[] → stores student names
    marks[] → stores student marks

 Problem:
Each student is split across two arrays → risk of inconsistency.

count:
- stores the current number of students
- defines the logical size of the arrays

*/

#define MAX 50   // maximum number of students
#define NLEN 50  // maximum length of each name

/* The Prototypes  */

void add(char names[][NLEN], int marks[], int *count, const char *name, int mark);
void removeAt(char names[][NLEN], int marks[], int *count, int index);
void update(int marks[], int count, int index, int newMark);
void display(char names[][NLEN], int marks[], int count);
int search(char names[][NLEN], int count, const char *query);
void topN(char names[][NLEN], int marks[], int count, int n);

/*  The main program start hier */
int main() {
    char names[MAX][NLEN]; // array of student names
    int marks[MAX];        // array of student marks
    int count = 0;         // number of students currently stored

    // Add some students
    add(names, marks, &count, "Ali", 85);
    add(names, marks, &count, "John", 90);
    add(names, marks, &count, "Sara", 75);

    // Display initial list
    display(names, marks, count);

    printf("\nAfter update:\n");
    update(marks, count, 1, 95); // update John's mark
    display(names, marks, count);

    printf("\nAfter remove:\n");
    removeAt(names, marks, &count, 0); // remove Ali
    display(names, marks, count);

    printf("\nSearch John:\n");
    int index = search(names, count, "John");
    if (index != -1)
        printf("Found at index %d\n", index);
    else
        printf("Not found\n");

    printf("\nTop 2:\n");
    topN(names, marks, count, 2);

    return 0;
}

/* 
   FUNCTION: add
   Purpose: Insert a new student into the system
 */
void add(char names[][NLEN], int marks[], int *Count, const char *name, int mark) {

    // Check if the array is full
    if (*Count >= MAX) {
        printf("List is full!\n");
        return;
    }

    /*
    Copy the name into the next available position.
    names[*count] represents the first free slot.
    */
    strcpy(names[*Count], name);

    // Store the mark in the parallel array
    marks[*Count] = mark;

    // Increase the number of students
    (*Count)++;
}

/* 
   FUNCTION: removeAt
   Purpose: Remove a student at a given index
 */
void removeAt(char names[][NLEN], int marks[], int *count, int index) {

    // Validate index
    if (index < 0 || index >= *count) {
        printf("Invalid index!\n");
        return;
    }

    /*
    Shift elements to the left:
    Each element takes the place of the next one.

    Important:
    We must shift BOTH arrays (names and marks),
    because data is stored separately.
    */
    for (int i = index; i < *count - 1; i++) {

        // Shift name
        strcpy(names[i], names[i + 1]);

        // Shift corresponding mark
        marks[i] = marks[i + 1];
    }

    // Reduce logical size
    (*count)--;
}

/*FUNCTION: update
Purpose: Modify the mark of a student*/ 

void update(int marks[], int count, int index, int newMark) {

    // Validate index
    if (index < 0 || index >= count) {
        printf("Invalid index!\n");
        return;
    }

    // Update the mark directly
    marks[index] = newMark;
}

/* 
   FUNCTION: display
   Purpose: Print all students
 */

void display(char names[][NLEN], int marks[], int count) {

    // Iterate through all stored students
    for (int i = 0; i < count; i++) {

        // Print index, name, and mark
        printf("%d. %s - %d\n", i, names[i], marks[i]);
    }
}


/* 
   FUNCTION: search
   Purpose: Find a student by name
 */
int search(char names[][NLEN], int count, const char *query) {

    // Loop through all students
    for (int i = 0; i < count; i++) {

        /*
        strcmp compares two strings:
        returns 0 if they are equal
        */
        if (strcmp(names[i], query) == 0) {
            return i; // return index if found
        }
    }

    // Return -1 if not found
    return -1;
} 





/* 
   FUNCTION: topN
   Purpose: Display the top N students (by mark)
    Without modifying original data
 */
void topN(char names[][NLEN], int marks[], int count, int n) {

    // Temporary arrays (copy of original data)
    char tempNames[MAX][NLEN];
    int tempMarks[MAX];

    /*  Step 1: Copy data  */
    for (int i = 0; i < count; i++) {
        strcpy(tempNames[i], names[i]);
        tempMarks[i] = marks[i];
    }

    /* Step 2: Sort (descending)  */
    for (int i = 0; i < count - 1; i++) {
        for (int j = i + 1; j < count; j++) {

            // If a higher mark is found → swap
            if (tempMarks[j] > tempMarks[i]) {

                // Swap marks
                int t = tempMarks[i];
                tempMarks[i] = tempMarks[j];
                tempMarks[j] = t;

                /*
                Critical:
                Names must be swapped as well
                to keep consistency.
                */
                char temp[NLEN];
                strcpy(temp, tempNames[i]);
                strcpy(tempNames[i], tempNames[j]);
                strcpy(tempNames[j], temp);
            }
        }
    }

    /*  Step 3: Display  */
    printf("Top %d students:\n", n);

    for (int i = 0; i < n && i < count; i++) {
        printf("%s - %d\n", tempNames[i], tempMarks[i]);
    }
}
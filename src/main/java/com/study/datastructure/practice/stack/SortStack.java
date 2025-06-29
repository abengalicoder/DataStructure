package com.study.datastructure.practice.stack;

import com.study.datastructure.stack.Stack;

/*
Stack: Sort Stack ( ** Interview Question)
The sortStack method takes a single argument, a Stack object.  The method should sort the elements in the stack in ascending order (the lowest value will be at the top of the stack) using only one additional stack.  The function should use the pop, push, peek, and isEmpty methods of the Stack object.

This will use the Stack class we created in these coding exercises:

To sort the stack, you should create a new, empty stack to hold the sorted elements.  Then, while the original stack is not empty, you should remove the top element from the original stack and compare it to the top element of the sorted stack.  If the top element of the sorted stack is greater than the current element, you should move the top element of the sorted stack back to the original stack until the current element is in the correct position.  Finally, you should add the current element to the sorted stack.

Once all the elements have been sorted, you should copy the sorted elements from the sorted stack to the original stack in the correct order.

Overall, the function should have a time complexity of O(n^2), where n is the number of elements in the original stack, due to the nested loops used to compare the elements.  However, the function should only use one additional stack, which could be useful in situations where memory is limited.
*/
public class SortStack {

    public static void main(String[] args) {
        Stack sortedStack = new Stack();
        addToSortedStack(sortedStack, 4);
        addToSortedStack(sortedStack, 1);
        addToSortedStack(sortedStack, 5);
        addToSortedStack(sortedStack, 2);
        addToSortedStack(sortedStack, 3);
    }

    private static void addToSortedStack(Stack stack, int value) {
        Stack helperStack = new Stack();

        if (stack.height == 0) {
            stack.push(value);
        } else {
            boolean readyToPush = false;
            while (!readyToPush) {
                int poppedValue = stack.pop();
                if (poppedValue > value) {
                    helperStack.push(poppedValue);
                } else {
                    stack.push(poppedValue);
                    stack.push(value);
                    readyToPush = true;
                }
            }
            while (helperStack.height >0) {
                stack.push(helperStack.pop());
            }
        }
        stack.print();
    }
}

package com.study.datastructure.stack;

public class Stack {
    Node top;
    int height = 0;

    void push(int data) {
        Node newNode = new Node(data);
        if (height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    int pop() {
        if (height == 0) {
            System.out.println("Stack is empty");
            return 0;
        }
        int data = top.data;
        top = top.next;
        height--;
        return data;
    }

    void print() {
        System.out.println("\nAll elements in stack:");
        Node current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

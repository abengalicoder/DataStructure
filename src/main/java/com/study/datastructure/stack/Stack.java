package com.study.datastructure.stack;

public class Stack {
    Node top;
    public int height = 0;

    public void push(int data) {
        Node newNode = new Node(data);
        if (height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public int pop() {
        if (height == 0) {
            System.out.println("Stack is empty");
            return -9999;
        }
        int data = top.data;
        top = top.next;
        height--;
        return data;
    }

    public void print() {
        System.out.println("\nAll elements in stack:");
        Node current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

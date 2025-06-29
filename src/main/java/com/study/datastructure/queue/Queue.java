package com.study.datastructure.queue;

public class Queue {
    Node head;
    Node first;
    Node last;
    int size;

    void enqueue(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            last = newNode;
            head.next = last;
            first = head;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    int dequeue() {
        if(head == null || size == 0) {
            System.out.println("Queue is empty deque");
            return 0;
        }
        size--;
        if(first == last) {
            int data = first.data;
            head = null;
            first = null;
            last = null;
            return data;
        } else {
            int data = first.data;
            first = first.next;
            head = first;
            return data;
        }
    }

    void display() {
        if(head == null || size == 0) {
            System.out.println("Queue is empty");
            return;
        }
        if(first == last) {
            System.out.println(first.data);
        } else {
            Node temp = first;
            while(temp != last) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }
}

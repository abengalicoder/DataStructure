package com.study.datastructure.linked.list.circular;

import lombok.Data;

@Data
class CircularLinkedList {
    Node head;

    void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node current = head;
            do {
                current = current.next;
            } while (current.next != head);
            current.next = newNode;
            newNode.next = head;
        }
    }

    void print() {
        System.out.println("\nPrinting Circular Linked List");
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
    }

    int size() {
        int size = 0;
        Node current = head;
        do {
            size++;
            current = current.next;
        } while (current != head);
        return size;
    }

    void insert(int index, int data) {
        if (index < 0 || index > size()) {
            System.out.println("Invalid index");
        }

        Node newNode = new Node(data);
        if (index == 0) {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            newNode.next = head;
            head = newNode;
            last.next = head;
        } else {
            int i = 1;
            Node current = head.next;
            while (i < index - 1) {
                current = current.next;
                i++;
            }
            if (current.next == head) { //last node
                current.next = newNode;
                newNode.next = head;
            } else {
                Node prevNextNode = current.next;
                current.next = newNode;
                newNode.next = prevNextNode;
            }
        }
    }

    void delete(int index) {
        if (index < 0 || index > size()) {
            System.out.println("Invalid index");
        }

        if (index == 0) {
            Node nextHead = head.next;
            Node current = head;
            while(current.next != head) {
                current = current.next;
            }
            current.next = nextHead;
            head = nextHead;
        } else {
            Node current = head.next;
            Node prevNextNode = head;
            int i = 1;
            while (i < index) {
                current = current.next;
                prevNextNode = prevNextNode.next;
                i++;
            }
            if (current.next == head) {
                prevNextNode.next = head;
            } else {
                prevNextNode.next = current.next;
            }
        }
    }

    void reverse() {
        Node prevHead = head;
        Node reverseList = null;
        Node current = head;
        Node next = null;
        do {
            next = current.next;
            current.next = reverseList;
            reverseList = current;
            current = next;
        } while (current != prevHead);
        head.next = reverseList;
        head = reverseList;
    }
}

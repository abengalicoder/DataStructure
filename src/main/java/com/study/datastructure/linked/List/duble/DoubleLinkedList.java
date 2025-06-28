package com.study.datastructure.linked.list.duble;

import lombok.Data;

@Data
public class DoubleLinkedList {

    private Node head;
    private Node tail;

    void add(int data) {
        Node newNode = new Node(data);

        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void print() {
        System.out.println();
        System.out.println("Print in order");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
        System.out.println("Print in reverse order");
        Node prev = tail;
        while (prev != null) {
            System.out.print(prev.data + " ");
            prev = prev.prev;
        }
    }

    int count() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    void insert(int index, int data) {
        Node newNode = new Node(data);

        if (index < 0 || index > count()) {
            System.out.println("Index out of bounds");
        }

        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            int i = 1;
            Node current = head.next;
            while (i < index -1) {
                current = current.next;
                i = i + 1;
            }
            if (current.next != null) {
                Node temp = current.next;
                current.next = newNode;
                newNode.prev = current;
                newNode.next = temp;
                temp.prev = newNode;
            } else {
                current.next = newNode;
                newNode.prev = current;
                tail = newNode;
            }
        }
    }

    void delete(int index) {
        if (index < 0 || index > count()) {
            System.out.println("Index out of bounds");
        }
        Node currentNode = head;
        if (index == 0) {
            Node newHead = currentNode.next;
            newHead.prev = null;
            head = newHead;
        } else {
            int i = 1;
            currentNode = currentNode.next;
            while (i < index -1) {
                currentNode = currentNode.next;
                i = i + 1;
            }
            if (currentNode.next == null) { // last node delete
                Node newTail = currentNode.prev;
                newTail.next = null;
                tail = newTail;
            } else {
                Node prevNode = currentNode.prev;
                prevNode.next = currentNode.next;
                currentNode.next.prev = prevNode;
            }
        }
    }
}

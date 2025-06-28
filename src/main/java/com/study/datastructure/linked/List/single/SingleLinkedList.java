package com.study.datastructure.linked.list.single;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class SingleLinkedList {
    private Node head;

    public static SingleLinkedList of(int... data) {
        SingleLinkedList list = new SingleLinkedList();
        for (int i = 0; i < data.length; i++) {
            list.add(data[i]);
        }
        return list;
    }

    public void add(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node newNode = new Node(data);
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void display() {
        System.out.println(System.lineSeparator());
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }

    public int count() {
        int size = 0;
        Node currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.next;
            size++;
        }
        return size;
    }

    public void insert(int position, int data) {
        if (position < 1 || position > count()) {
            System.out.println("\nIndex out of bounds");
        }

        Node newNode = new Node(data);
        Node currentNode = head;
        if (position == 1) {
            newNode.next = currentNode;
            head = newNode;
        } else {
            int index = 2;
            while (index < position) {
                currentNode = currentNode.next;
                index++;
            }
            if (currentNode.next == null) {
                currentNode.next = newNode;
            } else {
                Node temp = currentNode.next;
                currentNode.next = newNode;
                newNode.next = temp;
            }
        }
    }

    public void remove(int position) {
        if (position < 1 || position > count()) {
            System.out.println("Index out of bounds");
        }
        Node currentNode = head;
        if (position == 1) {
            head = currentNode.next;
        } else {
            int index = 2;
            Node previousNode = head;
            currentNode = head.next;
            while (index <= position-1) {
                previousNode = currentNode;
                currentNode = currentNode.next;
                index++;
            }
            if (currentNode.next == null) {
                previousNode.next = null;
            } else {
                previousNode.next = currentNode.next;
            }
        }
    }

    public void reverse() {

        Node currentNode = head;
        Node reversedNode = null;
        Node nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = reversedNode;
            reversedNode = currentNode;
            currentNode = nextNode;
        }
        head = reversedNode;
    }

    public Node[] getNodes() {
        Node [] nodes = new Node[count()];
        int index = 0;
        Node currentNode = head;
        while (currentNode != null) {
            nodes[index++]= currentNode;
            currentNode = currentNode.next;
        }
        return nodes;
    }

    public Node getNode(int index) {
        Node currentNode = head;
        int i = 0;
        while (i < index) {
            currentNode = currentNode.next;
            i++;
        }
        return currentNode;
    }
}

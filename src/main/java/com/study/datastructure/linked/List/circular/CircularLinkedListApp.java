package com.study.datastructure.linked.list.circular;

public class CircularLinkedListApp {

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.add(1);
        circularLinkedList.add(2);
        circularLinkedList.add(3);

        circularLinkedList.print();

        circularLinkedList.insert(0, 4);
        circularLinkedList.print();

        circularLinkedList.insert(4, 5);
        circularLinkedList.print();

        circularLinkedList.insert(1, 6);
        circularLinkedList.print();

        System.out.println("\nTime to delete");
        circularLinkedList.delete(0);
        circularLinkedList.print();

        circularLinkedList.delete(4);
        circularLinkedList.print();

        circularLinkedList.delete(1);
        circularLinkedList.print();

        System.out.println("\nReverse");
        circularLinkedList.reverse();
        circularLinkedList.print();
    }
}

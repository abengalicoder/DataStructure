package com.study.datastructure.linked.list.duble;

public class DoubleLinkedListApp {

    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();

        dll.add(1);
        dll.add(2);
        dll.add(3);

        dll.print();

        dll.insert(0, 4);
        dll.print();

        dll.insert(1, 5);
        dll.print();
        dll.insert(5, 6);
        dll.print();
        System.out.println("Time to delete");
        dll.delete(0);
        dll.print();

        dll.delete(1);
        dll.print();

        dll.delete(4);
        dll.print();
    }
}

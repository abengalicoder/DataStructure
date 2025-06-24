package com.study.datastructure.linked.list.single;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingleLinkedListApp {

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        System.out.println("Adding nodes to Single Linked List");
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("Print " + list.count() + " nodes");
        list.display();

        list.insert(0, 6);
        list.display();

        list.insert(1, 7);
        list.display();

        list.insert(7, 8);
        System.out.println("Print " + list.count() + " nodes");
        list.display();

        System.out.println("Start removing");
        list.remove(1);
        list.display();

        list.remove(7);
        list.display();

        list.remove(3);
        list.display();

        System.out.println("Reversing");
        list.reverse();
        list.display();
    }
}

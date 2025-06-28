package com.study.datastructure.linked.list.duble;

import lombok.Data;

@Data
public class Node {
    Node next;
    Node prev;
    int data;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

package com.study.datastructure.linked.list.single;

import lombok.Data;

@Data
public class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

package com.study.datastructure.stack;

import lombok.Data;

@Data
public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

package com.study.datastructure.queue;

import lombok.Data;

@Data
public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}

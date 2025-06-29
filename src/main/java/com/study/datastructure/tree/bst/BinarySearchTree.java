package com.study.datastructure.tree.bst;

public class BinarySearchTree {
    Leaf root;

    void add(int data) {
        if (root == null) {
            root = new Leaf(data);
        } else {
            Leaf current = root;
            Leaf prev = null;
            while (current != null) {
                prev = current;
                if (data > current.data) {
                    current = current.right;
                } else {
                    current = current.left;
                }
            }
            Leaf newLeaf = new Leaf(data);
            if (data > prev.data) {
                prev.right = newLeaf;
            } else {
                prev.left = newLeaf;
            }
        }
    }
}

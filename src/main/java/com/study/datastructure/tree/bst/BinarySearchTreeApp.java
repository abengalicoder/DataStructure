package com.study.datastructure.tree.bst;

public class BinarySearchTreeApp {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(1);
        bst.add(4);
        bst.add(6);
        bst.add(8);

        System.out.println("Created Binary Search Tree");
    }
}

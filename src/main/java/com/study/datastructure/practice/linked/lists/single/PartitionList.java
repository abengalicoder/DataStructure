package com.study.datastructure.practice.linked.lists.single;

import com.study.datastructure.linked.list.single.Node;
import com.study.datastructure.linked.list.single.SingleLinkedList;

/**
L: Partition List ( ** Interview Question)
⚠️ CAUTION: Advanced Challenge Ahead!

This Linked List problem is significantly more challenging than the ones we've tackled so far. It's common for students at this stage to find this exercise demanding, so don't worry if you're not ready to tackle it yet. It's perfectly okay to set it aside and revisit it later when you feel more confident.

If you decide to take on this challenge, I strongly advise using a hands-on approach: grab a piece of paper and visually map out each step.

This problem requires a clear understanding of how elements in a Linked List interact and move. By now, you've observed numerous Linked List animations in the course, which have prepared you for this moment.

This exercise will be a true test of your ability to apply those concepts practically. Remember, patience and persistence are key here!

Now, here is the exercise:

___________________________________



You have a singly linked list that DOES NOT HAVE A TAIL POINTER  (which will make this method simpler to implement).

Given a value x you need to rearrange the linked list such that all nodes with a value less than x come before all nodes with a value greater than or equal to x.

Additionally, the relative order of nodes in both partitions should remain unchanged.


Constraints:

The solution should traverse the linked list at most once.

The solution should not create a new linked list.


Input:

A singly linked list and an integer x.


Output:

The same linked list but rearranged as per the above criteria.


Function signature:

public void partitionList(int x);


Details:

The function partitionList takes an integer x as a parameter and modifies the current linked list in place according to the specified criteria. If the linked list is empty (i.e., head is null), the function should return immediately without making any changes.



Example 1:

Input:

Linked List: 3 , 8 , 5 , 10 , 2 , 1 x: 5

Process:

Values less than 5: 3, 2, 1

Values greater than or equal to 5: 8, 5, 10

Output:

Linked List: 3 , 2 , 1 , 8 , 5 , 10





Example 2:
Input:

Linked List: 1 , 4 , 3 , 2 , 5 , 2 x: 3

Process:

Values less than 3: 1, 2, 2

Values greater than or equal to 3: 4, 3, 5

Output:

Linked List: 1 , 2 , 2 , 4 , 3 , 5





Tips:

While traversing the linked list, maintain two separate chains: one for values less than x and one for values greater than or equal to x.

Use dummy nodes to simplify the handling of the heads of these chains.

After processing the entire list, connect the two chains to get the desired arrangement.



Note:

The solution must maintain the relative order of nodes. For instance, in the first example, even though 8 appears before 5 in the original list, the partitioned list must still have 8 before 5 as their relative order remains unchanged.

Note:

You must solve the problem WITHOUT MODIFYING THE VALUES in the list's nodes (i.e., only the nodes' next pointers may be changed.)
**/

public class PartitionList {

    public static void main(String[] args) {
        SingleLinkedList list = SingleLinkedList.of(8, 3, 2, 5, 4, 1);
        partition(list, 5);

        SingleLinkedList list1 = SingleLinkedList.of(3 , 8 , 5 , 10 , 2 , 1);
        partition(list1, 5);

        SingleLinkedList list2 = SingleLinkedList.of(1 , 4 , 3 , 2 , 5 , 2);
        partition(list2, 3);
    }

    private static SingleLinkedList partition(SingleLinkedList list, int targetData) {
        list.display();
        SingleLinkedList lessList = new SingleLinkedList();
        SingleLinkedList sameOrHigherList = new SingleLinkedList();

        Node[] nodes = list.getNodes();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].data >= targetData) {
                sameOrHigherList.add(nodes[i].data);
            } else {
                lessList.add(nodes[i].data);
            }
        }

        Node node = lessList.getNode(lessList.count()-1);
        node.next = sameOrHigherList.getNode(0);

        lessList.display();
        return lessList;
    }
}

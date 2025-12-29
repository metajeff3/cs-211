# Heap & Priority Queues

When you go the E.R., you usually don't go in first unless you are about to die. Imagine you are the person that decides that, how do you collect that data have fast peek of the first person in line? The answer lies in Heaps.

Heaps give us a great O(1) peek time, O(logn) for both addition and removal.

## What qualifies as a heap?

A heap my satisfy these criteria:

* Binary tree completeness: Filled from left-to-right. If you had an array that represents an binary tree, there'd be no gaps between the numbers.

* Parent <= Child for min & Parent => Child for max


How does one create and add numbers to a heap?

How does one remove numbers from a heap?

We first remove the first element of the heap. Then we take the further right bottom node and put it to the top.
Afterwards, we repeat this process until it is placed in the correct spot:

For a min heap.

* First check the children of the node. Find which is smaller. This is for when we swap, it'll satisfy the Parent <= Child requirement.

* Check if the current node is smaller than the smallest children node. If it is smaller, then that means it is already in the right spot. Swap with the smallest if not (so either left or right). REPEAT
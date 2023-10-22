# 1650 Lowest Common Ancestor of a Binary Tree III

Given two nodes of a binary tree `p` and `q`, return _their lowest common ancestor (LCA)_.

Each node will have a reference to its parent node. The definition for `Node` is below:

```
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
```

According to the [**definition of LCA on Wikipedia**](https://en.wikipedia.org/wiki/Lowest\_common\_ancestor): "The lowest common ancestor of two nodes p and q in a tree T is the lowest node that has both p and q as descendants (where we allow **a node to be a descendant of itself**)."

**Example 1:**![](https://assets.leetcode.com/uploads/2018/12/14/binarytree.png)

```
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
```

**Example 2:**![](https://assets.leetcode.com/uploads/2018/12/14/binarytree.png)

```
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5 since a node can be a descendant of itself according to the LCA definition.
```

**Example 3:**

```
Input: root = [1,2], p = 1, q = 2
Output: 1
```

**Constraints:**

* The number of nodes in the tree is in the range `[2, 105]`.
* `-10^9 <= Node.val <= 10^9`
* All `Node.val` are **unique**.
* `p != q`
* `p` and `q` exist in the tree.

### Solutions&#x20;

* The question is fundamentally same as [https://leetcode.com/problems/intersection-of-two-linked-lists/](https://leetcode.com/problems/intersection-of-two-linked-lists/)
* Solution 1: one node travel to root, use set to record the path, another node travel to root, check the node if in set
* Solution 2: use two stacks, pop until the last same element
* Solution 3: each travel other's road

{% tabs %}
{% tab title="Python" %}
```python
class Solution:
    def lowestCommonAncestor(self, root: Node, left: Node, right: Node) -> Node:
        if not root:
            return None
        a, b = left, right
        while a != b:
            a = a.parent if a.parent else right
            b = b.parent if b.parent else left
        return a
```
{% endtab %}

{% tab title="Second Tab" %}

{% endtab %}
{% endtabs %}

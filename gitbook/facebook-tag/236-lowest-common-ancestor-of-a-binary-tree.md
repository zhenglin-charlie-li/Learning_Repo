# 236 Lowest Common Ancestor of a Binary Tree

[236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the [definition of LCA on Wikipedia](https://en.wikipedia.org/wiki/Lowest\_common\_ancestor): “The lowest common ancestor is defined between two nodes `p` and `q` as the lowest node in `T` that has both `p` and `q` as descendants (where we allow a node to be a descendant of itself).”

&#x20;

**Example 1:**

![](https://assets.leetcode.com/uploads/2018/12/14/binarytree.png)

<pre><code><strong>Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
</strong><strong>Output: 3
</strong><strong>Explanation: The LCA of nodes 5 and 1 is 3.
</strong></code></pre>

**Example 2:**

![](https://assets.leetcode.com/uploads/2018/12/14/binarytree.png)

<pre><code><strong>Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
</strong><strong>Output: 5
</strong><strong>Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
</strong></code></pre>

**Example 3:**

<pre><code><strong>Input: root = [1,2], p = 1, q = 2
</strong><strong>Output: 1
</strong></code></pre>

&#x20;

**Constraints:**

* The number of nodes in the tree is in the range `[2, 105]`.
* `-109 <= Node.val <= 109`
* All `Node.val` are **unique**.
* `p != q`
* `p` and `q` will exist in the tree.

{% tabs %}
{% tab title="Python" %}
```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return None

        if root == p or root == q:
            return root

        left_res = self.lowestCommonAncestor(root.left, p, q)
        right_res = self.lowestCommonAncestor(root.right, p, q)

        if not left_res and not right_res:
            return None
        
        if left_res and right_res:
            return root

        if left_res:
            return left_res

        else:
            return right_res
        
```
{% endtab %}

{% tab title="Python" %}
```python
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
    
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root in (None, p, q):
            return root
            
        left_result = self.lowestCommonAncestor(root.left, p, q)
        right_result = self.lowestCommonAncestor(root.right, p, q)
        
        if left_result and right_result:
            return root
            
        return left_result or right_result
```
{% endtab %}
{% endtabs %}

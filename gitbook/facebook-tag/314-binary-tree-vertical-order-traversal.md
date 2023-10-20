# 314 Binary Tree Vertical Order Traversal

Given a binary tree, return the _vertical order_ traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

**Examples 1:**

<pre><code><strong>Input: [3,9,20,null,null,15,7]
</strong>
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7

<strong>Output:
</strong>
[
  [9],
  [3,15],
  [20],
  [7]
]
</code></pre>

**Examples 2:**

<pre><code><strong>Input: [3,9,8,4,0,1,7]
</strong>
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7

<strong>Output:
</strong>
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
</code></pre>

**Examples 3:**

<pre><code><strong>Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)
</strong>
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2

<strong>Output:
</strong>
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
</code></pre>

{% tabs %}
{% tab title="Python" %}
```python
class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        dict_x = collections.defaultdict(list)
        min_x = float('inf')
        max_x = float('-inf')
        # node, level, x
        queue = collections.deque()
        queue.append((root, 0, 0))
        while queue:
            level_size = len(queue)
            for i in range(level_size):
                node, level, x = queue.popleft()
                min_x = min(min_x, x)
                max_x = max(max_x, x)
                dict_x[x].append(node.val)

                if node.left:
                    queue.append((node.left, level + 1, x - 1))
                if node.right:
                    queue.append((node.right, level + 1, x + 1))
        return [dict_x[x] for x in range(min_x, max_x + 1)]
```
{% endtab %}

{% tab title="Python" %}
```python
class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        dict_x = collections.defaultdict(list)
        # node, level, x
        queue = collections.deque()
        queue.append((root, 0))
        while queue:
            node, x = queue.popleft()
            dict_x[x].append(node.val)

            if node.left:
                queue.append((node.left, x - 1))
            if node.right:
                queue.append((node.right, x + 1))
        return [dict_x[x] for x in sorted(dict_x.keys())]
```
{% endtab %}
{% endtabs %}

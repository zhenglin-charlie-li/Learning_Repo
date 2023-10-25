# 1428 Leftmost Column with at Least a One

_(This problem is an **interactive problem**.)_

A **row-sorted binary matrix** means that all elements are `0` or `1` and each row of the matrix is sorted in non-decreasing order.

Given a **row-sorted binary matrix** `binaryMatrix`, return _the index (0-indexed) of the **leftmost column** with a 1 in it_. If such an index does not exist, return `-1`.

**You can't access the Binary Matrix directly.** You may only access the matrix using a `BinaryMatrix`interface:

* `BinaryMatrix.get(row, col)` returns the element of the matrix at index `(row, col)` (0-indexed).
* `BinaryMatrix.dimensions()` returns the dimensions of the matrix as a list of 2 elements `[rows, cols]`, which means the matrix is `rows x cols`.

Submissions making more than `1000` calls to `BinaryMatrix.get` will be judged _Wrong Answer_. Also, any solutions that attempt to circumvent the judge will result in disqualification.

For custom testing purposes, the input will be the entire binary matrix `mat`. You will not have access to the binary matrix directly.

**Example 1:**

![](https://assets.leetcode.com/uploads/2019/10/25/untitled-diagram-5.jpg)

```
Input: mat = [[0,0],[1,1]]
Output: 0
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2019/10/25/untitled-diagram-4.jpg)

```
Input: mat = [[0,0],[0,1]]
Output: 1
```

**Example 3:**

![](https://assets.leetcode.com/uploads/2019/10/25/untitled-diagram-3.jpg)

```
Input: mat = [[0,0],[0,0]]
Output: -1
```

**Example 4:**

![](https://assets.leetcode.com/uploads/2019/10/25/untitled-diagram-6.jpg)

```
Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
Output: 1
```

**Constraints:**

* `rows == mat.length`
* `cols == mat[i].length`
* `1 <= rows, cols <= 100`
* `mat[i][j]` is either `0` or `1`.
* `mat[i]` is sorted in non-decreasing order.

{% tabs %}
{% tab title="Method 1" %}
<pre class="language-python"><code class="lang-python"># """
# This is BinaryMatrix's API interface.
# You should not implement it, or speculate about its implementation
# """
# Class BinaryMatrix(object):
#   def get(self, row: int, col: int) -> int:
#   def dimensions(self) -> List[int]:
<strong>
</strong><strong>class Solution:
</strong>    def leftMostColumnWithOne(self, binaryMatrix: 'BinaryMatrix') -> int:
        rows, cols = binaryMatrix.dimensions()
        for j in range(cols):
            for i in range(rows):
                if binaryMatrix.get(i, j) == 1:
                    return j
        return -1
</code></pre>
{% endtab %}

{% tab title="Method 2" %}
```python
# """
# This is BinaryMatrix's API interface.
# You should not implement it, or speculate about its implementation
# """
# Class BinaryMatrix(object):
#   def get(self, row: int, col: int) -> int:
#   def dimensions(self) -> List[int]:

class Solution:
    def leftMostColumnWithOne(self, binaryMatrix: 'BinaryMatrix') -> int:
        rows, cols = binaryMatrix.dimensions()
        ans = cols
        for i in range(rows):
            l, r = 0, ans - 1
            leftest = cols
            while l <= r:
                m = (l + r) // 2
                if binaryMatrix.get(i, m) == 1:
                    leftest = m
                    r = m - 1
                else:
                    l = m + 1
            ans = min(ans, leftest)    
        return ans if ans != cols else -1
```
{% endtab %}

{% tab title="Method 3" %}
```python
# """
# This is BinaryMatrix's API interface.
# You should not implement it, or speculate about its implementation
# """
# Class BinaryMatrix(object):
#   def get(self, row: int, col: int) -> int:
#   def dimensions(self) -> List[int]:

class Solution:
    def leftMostColumnWithOne(self, binaryMatrix: 'BinaryMatrix') -> int:
        rows, cols = binaryMatrix.dimensions()
        i, j = 0, cols - 1
        ans = -1
        while i < rows:
            if binaryMatrix.get(i, j) == 1:
                ans = j
                j -= 1
            else:
                i += 1
        return ans
```
{% endtab %}
{% endtabs %}

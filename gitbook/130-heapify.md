# 130 · Heapify

Description

Given an integer array, heapify it into a min-heap array.

For a heap array `A`, `A[0]` is the root of heap, and for each `A[i]`, `A[i * 2 + 1]` is the left child of `A[i]` and `A[i * 2 + 2]` is the right child of `A[i]`.

Example

_**Example 1**_

```
Input : [3,2,1,4,5]
Output : [1,2,3,4,5]
Explanation : return any one of the legitimate heap arrays. So [1,3,2,4,5] is also a correct result.
```

```python
class Solution:
    def heapify(self, a: List[int]):
        if not a or len(a) == 0:
            return
        
        n = len(a)
        for i in range(n // 2 - 1, -1, -1):
            self.siftDown(a, i, n)

    def siftDown(self, a, i, n):
        left, right = 2 * i + 1, 2 * i + 2
        min_index = i

        if left < n and a[left] < a[min_index]:
            min_index = left

        if right < n and a[right] < a[min_index]:
            min_index = right

        if min_index != i:
            a[min_index], a[i] = a[i], a[min_index]
            self.siftDown(a, min_index, n)
```

# Heap Implementation

```python
from typing import List

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

    def add(self, a, element):
        if not a or len(a) == 0:
            a.append(element)
            return
        a.append(element)
        self.siftUp(a, len(a) - 1)

    def siftUp(self, a, i):
        if i == 0:
            return
        parent = (i - 1) // 2
        if parent >= 0 and a[parent] > a[i]:
            a[i], a[parent] = a[parent], a[i]
            self.siftUp(a, parent)

    def pop(self, a):
        if not a or len(a) == 0:
            return None
        result = a[0]
        a[0], a[-1] = a[-1], a[0]
        a.pop()
        self.siftDown(a, 0, len(a))
        return result

    def peek(self, a):
        return a[0] if a else None

```

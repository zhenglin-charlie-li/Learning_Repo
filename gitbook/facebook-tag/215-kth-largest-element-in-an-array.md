# 215 Kth Largest Element in an Array

[215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)

Given an integer array `nums` and an integer `k`, return _the_ `kth` _largest element in the array_.

Note that it is the `kth` largest element in the sorted order, not the `kth` distinct element.

Can you solve it without sorting?

&#x20;

**Example 1:**

<pre><code><strong>Input: nums = [3,2,1,5,6,4], k = 2
</strong><strong>Output: 5
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
</strong><strong>Output: 4
</strong></code></pre>

&#x20;

**Constraints:**

* `1 <= k <= nums.length <= 105`
* `-104 <= nums[i] <= 104`

{% tabs %}
{% tab title="min_heap" %}
```python
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        min_heap = []

        for num in nums:
            heapq.heappush(min_heap, num)
            if len(min_heap) > k:
                heapq.heappop(min_heap)

        return min_heap[0]
```
{% endtab %}

{% tab title="max_heap" %}
```python
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        max_heap = [-num for num in nums]
        heapq.heapify(max_heap)

        for i in range(1, k):
            heapq.heappop(max_heap)

        return -max_heap[0]
```
{% endtab %}
{% endtabs %}

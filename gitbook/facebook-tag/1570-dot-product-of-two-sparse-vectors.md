# 1570 Dot Product of Two Sparse Vectors

Given two sparse vectors, compute their dot product.

Implement class `SparseVector`:

* `SparseVector(nums)` Initializes the object with the vector `nums`
* `dotProduct(vec)` Compute the dot product between the instance of _SparseVector_ and `vec`

A **sparse vector** is a vector that has mostly zero values, you should store the sparse vector **efficiently** and compute the dot product between two _SparseVector_.

**Follow up:** What if only one of the vectors is sparse?

**Example 1:**

<pre><code><strong>Input: nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0]
</strong><strong>Output: 8
</strong><strong>Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
</strong>v1.dotProduct(v2) = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8
</code></pre>

**Example 2:**

<pre><code><strong>Input: nums1 = [0,1,0,0,0], nums2 = [0,0,0,0,2]
</strong><strong>Output: 0
</strong><strong>Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
</strong>v1.dotProduct(v2) = 0*0 + 1*0 + 0*0 + 0*0 + 0*2 = 0
</code></pre>

**Example 3:**

<pre><code><strong>Input: nums1 = [0,1,0,0,2,0,0], nums2 = [1,0,0,0,3,0,4]
</strong><strong>Output: 6
</strong></code></pre>

**Constraints:**

* `n == nums1.length == nums2.length`
* `1 <= n <= 10^5`
* `0 <= nums1[i], nums2[i] <= 100`

{% tabs %}
{% tab title="Python" %}
```python
"""
Bruteforce
Time: O(n)
Space: O(1)
"""
class SparseVector:
    def __init__(self, nums: List[int]):
        self.nums = nums
        
    def dotProduct(self, vec: 'SparseVector') -> int:
        nums1 = vec.nums
        nums2 = self.nums
        length = len(nums1)
        ans = 0
        for i in range(length):
            ans += nums1[i] * nums2[i]
        return ans
    
```
{% endtab %}

{% tab title="Python" %}
```python
"""
Hashset
Time: O(L)
Space: O(L)
"""
class SparseVector:
    def __init__(self, nums: List[int]):
        self.nonzeros = dict()
        for i, n in enumerate(nums):
            if n != 0:
                nonzeros[i] = n
        
    def dotProduct(self, vec: 'SparseVector') -> int:
        nonzeros1 = self.nonzeros
        nonzeros2 = vec.nonzeros
        result = 0
        for i, n in nonzeros1.items():
            if i in nonzeros2:
                result += n * nonzeros2[i]
        return result
```
{% endtab %}
{% endtabs %}

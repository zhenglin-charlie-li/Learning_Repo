# 238 Product of Array Except Self

[238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)

Given an integer array `nums`, return _an array_ `answer` _such that_ `answer[i]` _is equal to the product of all the elements of_ `nums` _except_ `nums[i]`.

The product of any prefix or suffix of `nums` is **guaranteed** to fit in a **32-bit** integer.

You must write an algorithm that runs in `O(n)` time and without using the division operation.

&#x20;

**Example 1:**

<pre><code><strong>Input: nums = [1,2,3,4]
</strong><strong>Output: [24,12,8,6]
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: nums = [-1,1,0,-3,3]
</strong><strong>Output: [0,0,9,0,0]
</strong></code></pre>

&#x20;

**Constraints:**

* `2 <= nums.length <= 105`
* `-30 <= nums[i] <= 30`
* The product of any prefix or suffix of `nums` is **guaranteed** to fit in a **32-bit** integer.

{% tabs %}
{% tab title="S: O(n)" %}
```python
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        pre_fix = [1] * n
        post_fix = [1] * n
        res = [0] * n
        
        for i in range(1, n):
            pre_fix[i] = pre_fix[i - 1] * nums[i - 1]
        
        for i in range(n - 2, -1, -1):
            post_fix[i] = post_fix[i + 1] * nums[i + 1]
            
        for i in range(0, n):
            res[i] = pre_fix[i] * post_fix[i]

        return res
```
{% endtab %}

{% tab title="S: O(1)" %}
```python
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [0] * n
        pre_fix = 1

        for i in range(n):
            res[i] = pre_fix
            pre_fix *= nums[i] 

        post_fix = 1
        for i in range(n - 1, -1, -1):
            res[i] *= post_fix
            post_fix *= nums[i] 
        
        return res
```
{% endtab %}
{% endtabs %}

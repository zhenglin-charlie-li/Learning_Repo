# 53 Maximum Subarray

[53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)

Given an integer array `nums`, find the&#x20;

subarray with the largest sum, and return _its sum_.

&#x20;

**Example 1:**

<pre><code><strong>Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
</strong><strong>Output: 6
</strong><strong>Explanation: The subarray [4,-1,2,1] has the largest sum 6.
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: nums = [1]
</strong><strong>Output: 1
</strong><strong>Explanation: The subarray [1] has the largest sum 1.
</strong></code></pre>

**Example 3:**

<pre><code><strong>Input: nums = [5,4,-1,7,8]
</strong><strong>Output: 23
</strong><strong>Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
</strong></code></pre>

&#x20;

**Constraints:**

* `1 <= nums.length <= 105`
* `-104 <= nums[i] <= 104`

&#x20;

**Follow up:** If you have figured out the `O(n)` solution, try coding another solution using the **divide and conquer** approach, which is more subtle.

{% tabs %}
{% tab title="Greedy" %}
```python
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        res = -10000
        total = -10000

        for num in nums:
            total = max(total + num, num)
            res = max(res, total)

        return res
```
{% endtab %}

{% tab title="Second Tab" %}

{% endtab %}
{% endtabs %}

# 1 Two Sum

[1. Two Sum](https://leetcode.com/problems/two-sum/)

Given an array of integers `nums` and an integer `target`, return _indices of the two numbers such that they add up to `target`_.

You may assume that each input would have _**exactly**_** one solution**, and you may not use the _same_ element twice.

You can return the answer in any order.

&#x20;

**Example 1:**

<pre><code><strong>Input: nums = [2,7,11,15], target = 9
</strong><strong>Output: [0,1]
</strong><strong>Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: nums = [3,2,4], target = 6
</strong><strong>Output: [1,2]
</strong></code></pre>

**Example 3:**

<pre><code><strong>Input: nums = [3,3], target = 6
</strong><strong>Output: [0,1]
</strong></code></pre>

&#x20;

**Constraints:**

* `2 <= nums.length <= 104`
* `-109 <= nums[i] <= 109`
* `-109 <= target <= 109`
* **Only one valid answer exists.**

{% tabs %}
{% tab title="Brute Force" %}
```python
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        for i in range(n - 1):
            for j in range(i + 1, n):
                if nums[i] + nums[j] == target:
                    return [i, j]
        return []  # No solution found
```
{% endtab %}

{% tab title="Two-pass Hash Table" %}
```python
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        numMap = {}
        n = len(nums)

        # Build the hash table
        for i in range(n):
            numMap[nums[i]] = i

        # Find the complement
        for i in range(n):
            complement = target - nums[i]
            if complement in numMap and numMap[complement] != i:
                return [i, numMap[complement]]

        return []  # No solution found
```
{% endtab %}

{% tab title="One-pass Hash Table" %}
```python
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        numMap = {}
        n = len(nums)

        for i in range(n):
            complement = target - nums[i]
            if complement in numMap:
                return [numMap[complement], i]
            numMap[nums[i]] = i

        return []  # No solution found
```
{% endtab %}
{% endtabs %}

**Follow-up:** Can you come up with an algorithm that is less than `O(n2)` time complexity?

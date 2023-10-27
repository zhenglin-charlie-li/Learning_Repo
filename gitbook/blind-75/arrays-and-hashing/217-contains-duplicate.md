# 217 Contains Duplicate

[217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)

Given an integer array `nums`, return `true` if any value appears **at least twice** in the array, and return `false` if every element is distinct.

&#x20;

**Example 1:**

<pre><code><strong>Input: nums = [1,2,3,1]
</strong><strong>Output: true
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: nums = [1,2,3,4]
</strong><strong>Output: false
</strong></code></pre>

**Example 3:**

<pre><code><strong>Input: nums = [1,1,1,3,3,4,3,2,4,2]
</strong><strong>Output: true
</strong></code></pre>

&#x20;

**Constraints:**

* `1 <= nums.length <= 105`
* `-109 <= nums[i] <= 109`

{% tabs %}
{% tab title="Set" %}
```python
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        appeared = set()
        for num in nums:
            if num in appeared:
                return True
            appeared.add(num)
        return False
```
{% endtab %}

{% tab title="Second Tab" %}

{% endtab %}
{% endtabs %}

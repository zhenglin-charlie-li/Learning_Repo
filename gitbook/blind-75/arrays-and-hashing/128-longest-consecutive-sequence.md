# 128 Longest Consecutive Sequence

[128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/)&#x20;

Given an unsorted array of integers `nums`, return _the length of the longest consecutive elements sequence._

You must write an algorithm that runs in `O(n)` time.

&#x20;

**Example 1:**

<pre><code><strong>Input: nums = [100,4,200,1,3,2]
</strong><strong>Output: 4
</strong><strong>Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: nums = [0,3,7,2,5,8,4,6,0,1]
</strong><strong>Output: 9
</strong></code></pre>

&#x20;

**Constraints:**

* `0 <= nums.length <= 105`
* `-109 <= nums[i] <= 109`

{% tabs %}
{% tab title="Python" %}
```python
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0
            
        nums_set = set(nums)
        res = 0
        
        @lru_cache(maxsize=None)
        def dfs(num):
            if not (num - 1) in nums_set:
                return 1
            else:
                return dfs(num - 1) + 1
        
        for num in nums:
            res = max(res, dfs(num))
        return res                
```
{% endtab %}

{% tab title="Python" %}
```python
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0

        nums_set = set(nums)
        res = 0

        for num in nums:
            if (num + 1) in nums_set:
                continue
            length = 1
            while (num - 1) in nums_set:
                length += 1
                num -= 1
            res = max(length, res)

        return res    
        
```
{% endtab %}
{% endtabs %}

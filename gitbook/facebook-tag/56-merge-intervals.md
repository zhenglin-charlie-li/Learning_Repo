# 56 Merge Intervals

[56. Merge Intervals](https://leetcode.com/problems/merge-intervals/)

Given an array of `intervals` where `intervals[i] = [starti, endi]`, merge all overlapping intervals, and return _an array of the non-overlapping intervals that cover all the intervals in the input_.

&#x20;

**Example 1:**

<pre><code><strong>Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
</strong><strong>Output: [[1,6],[8,10],[15,18]]
</strong><strong>Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: intervals = [[1,4],[4,5]]
</strong><strong>Output: [[1,5]]
</strong><strong>Explanation: Intervals [1,4] and [4,5] are considered overlapping.
</strong></code></pre>

&#x20;

**Constraints:**

* `1 <= intervals.length <= 104`
* `intervals[i].length == 2`
* `0 <= starti <= endi <= 104`

{% tabs %}
{% tab title="Python" %}
```python
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key = lambda x: x[0])
        res = [intervals[0]]

        for interval in intervals[1:]:
            start, end = interval
            if start <= res[-1][1]:
                res[-1][1] = max(end, res[-1][1])
            else:
                res.append(interval)

        return res
```
{% endtab %}
{% endtabs %}

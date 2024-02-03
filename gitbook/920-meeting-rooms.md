# 920 · Meeting Rooms

Description

Given an array of meeting time intervals consisting of start and end times `[[s1,e1],[s2,e2],...] (si < ei)`, determine if a person could attend all meetings.

Example

**Example1**

```
Input: intervals = [(0,30),(5,10),(15,20)]
Output: false
Explanation: (0,30), (5,10) and (0,30),(15,20) will conflict
```

**Example2**

```
Input: intervals = [(5,8),(9,15)]
Output: true
Explanation: Two times will not conflict 
```

{% tabs %}
{% tab title="Sort by start time" %}
```python
class Solution:
    def can_attend_meetings(self, intervals: List[Interval]) -> bool:
        if not intervals or len(intervals) == 0:
            return True

        intervals_sorted = sorted(intervals, key=lambda x: (x.start))

        for i in range(1, len(intervals_sorted)):
            if intervals_sorted[i - 1].end > intervals_sorted[i].start:
                return False

        return True
```
{% endtab %}

{% tab title="Heap" %}
```python
class Solution:
    def can_attend_meetings(self, intervals: List[Interval]) -> bool:
        heap = []
        for start, end in intervals:
            if heap and -heap[0][1] > start:
                return False                
            heapq.heappush(heap, (start, end))
        return True
```
{% endtab %}
{% endtabs %}

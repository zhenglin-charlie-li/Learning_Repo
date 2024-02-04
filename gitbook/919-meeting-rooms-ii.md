# 919 · Meeting Rooms II

Description

Given an array of meeting time intervals consisting of start and end times `[[s1,e1],[s2,e2],...] (si < ei)`, find the minimum number of conference rooms required.)

Example

**Example1**

```
Input: intervals = [(0,30),(5,10),(15,20)]Output: 2Explanation:We need two meeting roomsroom1: (0,30)room2: (5,10),(15,20)
```

**Example2**

```
Input: intervals = [(2,7)]Output: 1Explanation: Only need one meeting room
```

{% tabs %}
{% tab title="Sweep Line " %}
```python
class Solution:
    def min_meeting_rooms(self, intervals: List[Interval]) -> int:
        events = []

        for interval in intervals:
            start, end = interval.start, interval.end
            events.append((start, 1))
            events.append((end, -1))

        events = sorted(events, key=lambda x:(x[0], x[1]))

        rooms_in_use = 0
        max_rooms = 0

        for event in events:
            rooms_in_use += event[1]
            max_rooms = max(max_rooms, rooms_in_use)

        return max_rooms
```
{% endtab %}

{% tab title="Heap" %}
```python
class Solution:
    def min_meeting_rooms(self, intervals: List[Interval]) -> int:
        if not intervals:
            return 0

        heap = []
        meetings = sorted(intervals, key=lambda x: x.start)

        for meeting in meetings:
            start_time, end_time = meeting.start, meeting.end

            if heap and heap[0] <= start_time:   
                heapq.heappop(heap)

            heapq.heappush(heap, end_time)

        return len(heap)
```
{% endtab %}
{% endtabs %}

# 920 · Meeting Rooms

Description

Given an array of meeting time intervals consisting of start and end times `[[s1,e1],[s2,e2],...] (si < ei)`, determine if a person could attend all meetings.

\


Example

**Example1**

```
Input: intervals = [(0,30),(5,10),(15,20)]Output: falseExplanation: (0,30), (5,10) and (0,30),(15,20) will conflict
```

**Example2**

```
Input: intervals = [(5,8),(9,15)]Output: trueExplanation: Two times will not conflict 
```

{% tabs %}
{% tab title="First Tab" %}
```python
class Solution:
    def can_attend_meetings(self, intervals: List[Interval]) -> bool:
        events = []

        for interval in intervals:
            start, end = interval.start, interval.end
            events.append((start, 1))
            events.append((end, -1))

        events = sorted(events, key=lambda x:(x[0], x[1]))

        rooms_in_use = 0

        for event in events:
            rooms_in_use += event[1]
            if rooms_in_use > 1:
                return False

        return True

```
{% endtab %}

{% tab title="Second Tab" %}

{% endtab %}
{% endtabs %}

# 391 · Number of Airplanes in the Sky

Description

Given an list `interval`, which are taking off and landing time of the flight. How many airplanes are there at most at the same time in the sky?

Example

**Example 1:**

```
Input: [(1, 10), (2, 3), (5, 8), (4, 7)]Output: 3Explanation:The first airplane takes off at 1 and lands at 10.The second ariplane takes off at 2 and lands at 3.The third ariplane takes off at 5 and lands at 8.The forth ariplane takes off at 4 and lands at 7.During 5 to 6, there are three airplanes in the sky.
```

**Example 2:**

```
Input: [(1, 2), (2, 3), (3, 4)]Output: 1Explanation: Landing happen before taking off.
```

{% tabs %}
{% tab title="First Tab" %}
```python
class Solution:
    """
    @param airplanes: An interval array
    @return: Count of airplanes are in the sky.
    """
    def count_of_airplanes(self, airplanes: List[Interval]) -> int:
        list_up_down = []

        for airplane in airplanes:
            up_time, down_time = airplane.start, airplane.end
            list_up_down.append((up_time, 1))
            list_up_down.append((down_time, -1))

        # Corrected: Assign the sorted result back to list_up_down
        list_up_down.sort(key=lambda x: (x[0], x[1]))


        res, count = 0, 0
        for time, action in list_up_down:
            count += action
            res = max(res, count)

        return res
```
{% endtab %}

{% tab title="Second Tab" %}

{% endtab %}
{% endtabs %}

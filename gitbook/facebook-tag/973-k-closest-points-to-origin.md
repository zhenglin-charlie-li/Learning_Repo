# 973 K Closest Points to Origin

[973. K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/)

Given an array of `points` where `points[i] = [xi, yi]` represents a point on the **X-Y** plane and an integer `k`, return the `k` closest points to the origin `(0, 0)`.

The distance between two points on the **X-Y** plane is the Euclidean distance (i.e., `√(x1 - x2)2 + (y1 - y2)2`).

You may return the answer in **any order**. The answer is **guaranteed** to be **unique** (except for the order that it is in).

&#x20;

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/03/03/closestplane1.jpg)

<pre><code><strong>Input: points = [[1,3],[-2,2]], k = 1
</strong><strong>Output: [[-2,2]]
</strong><strong>Explanation:
</strong>The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) &#x3C; sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
</code></pre>

**Example 2:**

<pre><code><strong>Input: points = [[3,3],[5,-1],[-2,4]], k = 2
</strong><strong>Output: [[3,3],[-2,4]]
</strong><strong>Explanation: The answer [[-2,4],[3,3]] would also be accepted.
</strong></code></pre>

&#x20;

**Constraints:**

* `1 <= k <= points.length <= 104`
* `-104 <= xi, yi <= 104`

{% tabs %}
{% tab title="Python" %}
```python
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        max_heap = []

        for x, y in points:
            heapq.heappush(max_heap, (- (x * x + y * y), x, y))
            if len(max_heap) > k:
                heapq.heappop(max_heap)

        # Negate the values back to return the k closest points
        return [[x, y] for (_, x, y) in max_heap]
```
{% endtab %}

{% tab title="Java" %}
```java
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // k smallest, max heap
        PriorityQueue<Point> pq = new PriorityQueue<>(
            (a, b) -> b.distance - a.distance
        );
        for (int[] point : points) {
            pq.offer(new Point(point[0], point[1]));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] res = new int[k][2];
        int index = 0;
        for (Point p : pq) {
            res[index][0] = p.x;
            res[index][1] = p.y;
            index++;
        }
        return res;
    }
}

class Point {
    int x;
    int y;
    int distance;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.distance = x * x + y * y;
    }
}
```
{% endtab %}
{% endtabs %}

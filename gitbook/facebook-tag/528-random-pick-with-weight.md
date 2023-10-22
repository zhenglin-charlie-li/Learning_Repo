# 528 Random Pick with Weight

[528. Random Pick with Weight](https://leetcode.com/problems/random-pick-with-weight/)

You are given a **0-indexed** array of positive integers `w` where `w[i]` describes the **weight** of the `ith` index.

You need to implement the function `pickIndex()`, which **randomly** picks an index in the range `[0, w.length - 1]` (**inclusive**) and returns it. The **probability** of picking an index `i` is `w[i] / sum(w)`.

* For example, if `w = [1, 3]`, the probability of picking index `0` is `1 / (1 + 3) = 0.25` (i.e., `25%`), and the probability of picking index `1` is `3 / (1 + 3) = 0.75` (i.e., `75%`).

&#x20;

**Example 1:**

<pre><code><strong>Input
</strong>["Solution","pickIndex"]
[[[1]],[]]
<strong>Output
</strong>[null,0]

<strong>Explanation
</strong>Solution solution = new Solution([1]);
solution.pickIndex(); // return 0. The only option is to return 0 since there is only one element in w.
</code></pre>

**Example 2:**

<pre><code><strong>Input
</strong>["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
<strong>Output
</strong>[null,1,1,1,1,0]

<strong>Explanation
</strong>Solution solution = new Solution([1, 3]);
solution.pickIndex(); // return 1. It is returning the second element (index = 1) that has a probability of 3/4.
solution.pickIndex(); // return 1
solution.pickIndex(); // return 1
solution.pickIndex(); // return 1
solution.pickIndex(); // return 0. It is returning the first element (index = 0) that has a probability of 1/4.

Since this is a randomization problem, multiple answers are allowed.
All of the following outputs can be considered correct:
[null,1,1,1,1,0]
[null,1,1,1,1,1]
[null,1,1,1,0,0]
[null,1,1,1,0,1]
[null,1,0,1,0,0]
......
and so on.
</code></pre>

&#x20;

**Constraints:**

* `1 <= w.length <= 104`
* `1 <= w[i] <= 105`
* `pickIndex` will be called at most `104` times.

{% tabs %}
{% tab title="Python" %}
```python
class Solution:

    def __init__(self, w: List[int]):
        self.presum = []
        self.sum = 0
        for weight in w:
            self.sum += weight
            self.presum.append(self.sum)

    def pickIndex(self) -> int:
        # [1, sum]
        x = random.randint(1, self.sum)
        idx = self.find_index(x)
        return idx

    def find_index(self, x: int) -> int:
        ans = 0
        # [l, r]
        l, r = 0, len(self.presum) - 1
        while l <= r:
            mid = (l + r) // 2
            if self.presum[mid] >= x:
                ans = mid
                r = mid - 1
            else:
                l = mid + 1
        return ans

# index: [0, 1, 2, 3]
# value: [1, 2, 3, 4]
# total: 10
# presum:[1, 3, 6, 10]
# random pick a number x from[1, 10]
# find the least number that >= x
# return the index
```
{% endtab %}

{% tab title="Second Tab" %}

{% endtab %}
{% endtabs %}

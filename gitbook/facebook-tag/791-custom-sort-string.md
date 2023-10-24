# 791 Custom Sort String

[791. Custom Sort String](https://leetcode.com/problems/custom-sort-string/)

You are given two strings order and s. All the characters of `order` are **unique** and were sorted in some custom order previously.

Permute the characters of `s` so that they match the order that `order` was sorted. More specifically, if a character `x` occurs before a character `y` in `order`, then `x` should occur before `y` in the permuted string.

Return _any permutation of_ `s` _that satisfies this property_.

&#x20;

**Example 1:**

<pre><code><strong>Input: order = "cba", s = "abcd"
</strong><strong>Output: "cbad"
</strong><strong>Explanation: 
</strong>"a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.
</code></pre>

**Example 2:**

<pre><code><strong>Input: order = "cbafg", s = "abcd"
</strong><strong>Output: "cbad"
</strong></code></pre>

&#x20;

**Constraints:**

* `1 <= order.length <= 26`
* `1 <= s.length <= 200`
* `order` and `s` consist of lowercase English letters.
* All the characters of `order` are **unique**.

{% tabs %}
{% tab title="Python" %}
```python
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        char_count = {}
        for c in s:
            if c in char_count:
                char_count[c] += 1
            else:
                char_count[c] = 1
        result = []
        for c in order:
            if c in char_count:
                result.extend([c] * char_count[c])
                del char_count[c]
        for c, freq in char_count.items():
            result.extend([c] * freq)
        return ''.join(result)
```
{% endtab %}

{% tab title="Second Tab" %}

{% endtab %}
{% endtabs %}

# 1249 Minimum Remove to Make Valid Parentheses

[1249. Minimum Remove to Make Valid Parentheses](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/)

Given a string s of `'('` , `')'` and lowercase English characters.

Your task is to remove the minimum number of parentheses ( `'('` or `')'`, in any positions ) so that the resulting _parentheses string_ is valid and return **any** valid string.

Formally, a _parentheses string_ is valid if and only if:

* It is the empty string, contains only lowercase characters, or
* It can be written as `AB` (`A` concatenated with `B`), where `A` and `B` are valid strings, or
* It can be written as `(A)`, where `A` is a valid string.

&#x20;

**Example 1:**

<pre><code><strong>Input: s = "lee(t(c)o)de)"
</strong><strong>Output: "lee(t(c)o)de"
</strong><strong>Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: s = "a)b(c)d"
</strong><strong>Output: "ab(c)d"
</strong></code></pre>

**Example 3:**

<pre><code><strong>Input: s = "))(("
</strong><strong>Output: ""
</strong><strong>Explanation: An empty string is also valid.
</strong></code></pre>

&#x20;

**Constraints:**

* `1 <= s.length <= 105`
* `s[i]` is either`'('` , `')'`, or lowercase English letter`.`

{% tabs %}
{% tab title="Python" %}
```python
class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        stack = deque()
        to_delete_index = []
        cnt = 0
        for i in range(len(s)):
            char = s[i]
            if char == '(':
                stack.append(i)
            elif char == ')':
                if not stack:
                    to_delete_index.append(i)
                else:
                    stack.pop()
        to_delete_index.extend(stack)
        return "".join(s[i] for i in range(len(s)) if i not in to_delete_index)
```
{% endtab %}

{% tab title="Second Tab" %}

{% endtab %}
{% endtabs %}

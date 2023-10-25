# 150 Evaluate Reverse Polish Notation

[150. Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)&#x20;

You are given an array of strings `tokens` that represents an arithmetic expression in a [Reverse Polish Notation](http://en.wikipedia.org/wiki/Reverse\_Polish\_notation).

Evaluate the expression. Return _an integer that represents the value of the expression_.

**Note** that:

* The valid operators are `'+'`, `'-'`, `'*'`, and `'/'`.
* Each operand may be an integer or another expression.
* The division between two integers always **truncates toward zero**.
* There will not be any division by zero.
* The input represents a valid arithmetic expression in a reverse polish notation.
* The answer and all the intermediate calculations can be represented in a **32-bit** integer.

&#x20;

**Example 1:**

<pre><code><strong>Input: tokens = ["2","1","+","3","*"]
</strong><strong>Output: 9
</strong><strong>Explanation: ((2 + 1) * 3) = 9
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: tokens = ["4","13","5","/","+"]
</strong><strong>Output: 6
</strong><strong>Explanation: (4 + (13 / 5)) = 6
</strong></code></pre>

**Example 3:**

<pre><code><strong>Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
</strong><strong>Output: 22
</strong><strong>Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
</strong>= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
</code></pre>

&#x20;

**Constraints:**

* `1 <= tokens.length <= 104`
* `tokens[i]` is either an operator: `"+"`, `"-"`, `"*"`, or `"/"`, or an integer in the range `[-200, 200]`.

{% tabs %}
{% tab title="Python" %}
```python
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []

        for token in tokens:
            # only positive value will be true in isdigit()
            # so we need to remove any - infront
            if token.lstrip('-').isdigit():
                stack.append(int(token))
            else:
                if token == '+':
                    a = stack.pop()
                    b = stack.pop()
                    stack.append(b + a)
                if token == '-':
                    a = stack.pop()
                    b = stack.pop()
                    stack.append(b - a)
                if token == '*':
                    a = stack.pop()
                    b = stack.pop()
                    stack.append(b * a)
                if token == '/':
                    a = stack.pop()
                    b = stack.pop()
                    stack.append(int(b / a))

        return stack.pop()
```
{% endtab %}

{% tab title="Second Tab" %}

{% endtab %}
{% endtabs %}

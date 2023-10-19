# 680 Valid Palindrome II

[680. Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii/)

Given a string `s`, return `true` _if the_ `s` _can be palindrome after deleting **at most one** character from it_.

&#x20;

**Example 1:**

<pre><code><strong>Input: s = "aba"
</strong><strong>Output: true
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: s = "abca"
</strong><strong>Output: true
</strong><strong>Explanation: You could delete the character 'c'.
</strong></code></pre>

**Example 3:**

<pre><code><strong>Input: s = "abc"
</strong><strong>Output: false
</strong></code></pre>

&#x20;

**Constraints:**

* `1 <= s.length <= 105`
* `s` consists of lowercase English letters.

{% tabs %}
{% tab title="Python" %}
```python
class Solution:
    def validPalindrome(self, s: str) -> bool:
        def validPalindrome(s: str, l: int, r: int) -> bool:
            i, j = l, r
            while i < j:
                if s[i] != s[j]:
                    return False, i, j
                i, j = i + 1, j - 1
            return True, i, j
        
        i, j = 0, len(s) - 1
        result, i, j = validPalindrome(s, i, j)
        if result:
            return True
        result, _, _ = validPalindrome(s, i + 1, j)
        if result:
            return True
        result, _, _ = validPalindrome(s, i, j - 1)
        if result:
            return True
        return False
        
```
{% endtab %}

{% tab title="Java" %}
```java
class Solution {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        Result result = validPalindrome(chars, 0, chars.length - 1);
        if (result.result) {
            return true;
        }
        Result resultDeleteLeft = validPalindrome(chars, result.left + 1, result.right);
        if (resultDeleteLeft.result) {
            return true;
        }
        Result resultDeleteRight = validPalindrome(chars, result.left, result.right - 1);
        if (resultDeleteRight.result) {
            return true;
        }
        return false;
    }

    public Result validPalindrome(char[] chars, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            if (chars[i] != chars[j]) {
                return new Result(false, i, j);
            }
            i++;
            j--;
        }
        return new Result(true, i, j);
    }
}

class Result {
    boolean result;
    int left;
    int right;

    public Result (boolean result, int left, int right) {
        this.result = result;
        this.left = left;
        this.right = right;
    }
}
```
{% endtab %}
{% endtabs %}

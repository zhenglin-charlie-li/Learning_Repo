# 242 Valid Anagram

[242. Valid Anagram](https://leetcode.com/problems/valid-anagram/)

Given two strings `s` and `t`, return `true` _if_ `t` _is an anagram of_ `s`_, and_ `false` _otherwise_.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

&#x20;

**Example 1:**

<pre><code><strong>Input: s = "anagram", t = "nagaram"
</strong><strong>Output: true
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: s = "rat", t = "car"
</strong><strong>Output: false
</strong></code></pre>

&#x20;

**Constraints:**

* `1 <= s.length, t.length <= 5 * 104`
* `s` and `t` consist of lowercase English letters.

{% tabs %}
{% tab title="Sort" %}
```python
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        sorted_s = sorted(s)
        sorted_t = sorted(t)
        return sorted_s == sorted_t
```
{% endtab %}

{% tab title="Hash Table" %}
```python
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        count = defaultdict(int)
        
        # Count the frequency of characters in string s
        for x in s:
            count[x] += 1
        
        # Decrement the frequency of characters in string t
        for x in t:
            count[x] -= 1
        
        # Check if any character has non-zero frequency
        for val in count.values():
            if val != 0:
                return False
        
        return True
```
{% endtab %}

{% tab title="Array as HashTable" %}
```python
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        count = [0] * 26
        
        # Count the frequency of characters in string s
        for x in s:
            count[ord(x) - ord('a')] += 1
        
        # Decrement the frequency of characters in string t
        for x in t:
            count[ord(x) - ord('a')] -= 1
        
        # Check if any character has non-zero frequency
        for val in count:
            if val != 0:
                return False
        
        return True
```
{% endtab %}

{% tab title="Counter" %}
```python
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        return Counter(s) == Counter(t)
```
{% endtab %}
{% endtabs %}

&#x20;

**Follow up:** What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

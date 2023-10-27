# 49 Group Anagrams

[49. Group Anagrams](https://leetcode.com/problems/group-anagrams/)

Given an array of strings `strs`, group **the anagrams** together. You can return the answer in **any order**.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

&#x20;

**Example 1:**

<pre><code><strong>Input: strs = ["eat","tea","tan","ate","nat","bat"]
</strong><strong>Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: strs = [""]
</strong><strong>Output: [[""]]
</strong></code></pre>

**Example 3:**

<pre><code><strong>Input: strs = ["a"]
</strong><strong>Output: [["a"]]
</strong></code></pre>

&#x20;

**Constraints:**

* `1 <= strs.length <= 104`
* `0 <= strs[i].length <= 100`
* `strs[i]` consists of lowercase English letters.



{% tabs %}
{% tab title="Sort" %}
```python
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams_map = collections.defaultdict(list)

        for each_str in strs:
            sorted_str = "".join(sorted(each_str))
            anagrams_map[sorted_str].append(each_str)

        return anagrams_map.values()
```
{% endtab %}

{% tab title="Count" %}
```python
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams_map = collections.defaultdict(list)

        for each_str in strs:
            sorted_str = "".join(sorted(each_str))
            anagrams_map[sorted_str].append(each_str)

        return anagrams_map.values()
```
{% endtab %}
{% endtabs %}

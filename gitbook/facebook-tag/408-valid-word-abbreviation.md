# 408 Valid Word Abbreviation

[408. Valid Word Abbreviation (Easy)](https://leetcode.com/problems/valid-word-abbreviation/)

Given a non-empty string `s` and an abbreviation `abbr`, return whether the string matches with the given abbreviation.

A string can be abbreviated by replacing any number of non-adjacentnon-empty substrings with their lengths. The lengths should not have leading zeros.

&#x20;For example, a string such as `substitution` could be abbreviated as (but not limited to):&#x20;

* `s10n`
* `sub4u4`
* `12`
* `su3i1u2on`
* `substitution`

However, the following are not valid:

* `s55n` the replaced substrings are adjacent
* `s010n` has leading 0
* `s0ubstitution` replace empty string

A string such as `"word"` contains only the following valid abbreviations:

```
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
```

Notice that only the above abbreviations are valid abbreviations of the string `"word"`. Any other string is not a valid abbreviation of `"word"`.

Note:\
Assume `s` contains only lowercase letters and `abbr` contains only lowercase letters and digits.

Example 1:\


```
Given s = "internationalization", abbr = "i12iz4n":
Return true.
```

Example 2:\


```
Given s = "apple", abbr = "a2e":
Return false.
```

{% tabs %}
{% tab title="Python" %}
```python
class Solution:
    def validWordAbbreviation(self, word: str, abbr: str) -> bool:
        i, j = 0, 0
        m, n = len(word), len(abbr)
        while i < m and j < n:
            # not digit
            if not abbr[j].isdigit():
                if word[i] != abbr[j]:
                    return False
                i += 1
                j += 1
            # is digit
            else:
                len_replaced = 0
                if int(abbr[j]) == 0:
                    return False
                while j < m and abbr[j].isdigit():
                    len_replaced = len_replaced * 10 + int(abbr[j])
                    j += 1
                i += len_replaced
        return i == m and j == n
```
{% endtab %}

{% tab title="Second Tab" %}

{% endtab %}
{% endtabs %}

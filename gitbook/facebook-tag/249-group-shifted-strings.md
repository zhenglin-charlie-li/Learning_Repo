# 249 Group Shifted Strings

## 249. Group Shifted Strings

Given a string, we can "shift" each of its letter to its successive letter, for example: `"abc" -> "bcd"`. We can keep "shifting" which forms the sequence:

```
"abc" -> "bcd" -> ... -> "xyz"
```

Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

Example:

```
Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Output:
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
```

\


{% tabs %}
{% tab title="Python" %}
```python
class Solution:
    def groupStrings(self, strings: List[str]) -> List[List[str]]:
        # key: tuple of transformed tuple, value: a list of original strings
        map = defaultdict(list)

        # get transformed tuple
        # "a" -> ()
        # "z" -> ()
        # "az" -> (25)
        # "ba" -> (25)
        def getTransformedTuple(s: str):
            result = []
            for i in range(1, len(s)):
                result.append(
                    (ord(s[i]) - ord(s[i - 1])) if ((ord(s[i]) - ord(s[i - 1])) >= 0) else (
                            ord(s[i]) - ord(s[i - 1]) + 26))
            return tuple(result)

        for string in strings:
            # () -> ["a", "z"]
            # (25) -> ["az", "ba"]
            transformed_string = getTransformedTuple(string)
            map[transformed_string].append(string)

        # () -> ["a", "z"]
        # (25) -> ["az", "ba"]
        # [["a", "z"], ["az", "ba"]]
        return [list for list in map.values()]
```
{% endtab %}

{% tab title="Python" %}
```python
class Solution:
    def groupStrings(self, strings: List[str]) -> List[List[str]]:
        if not self:
            return []

        def hash(string: str) -> tuple:
            return tuple((ord(c) - ord(string[0])) for c in string)

        map = collections.defaultdict(list)
        for string in strings:
            map[hash(string)].append(string)
        return list(map.values())
```
{% endtab %}
{% endtabs %}

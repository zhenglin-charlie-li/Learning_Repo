# 659 Encode and Decode Strings

Design an algorithm to **encode** a list of `strings` to a string. The **encoded string** is then sent over the network and is **decoded** back to the original list of strings. **Please implement encode and decode.**

**Example1**

```
Input: [“lint”,“code”,“love”,“you”] 
Output: [“lint”,“code”,“love”,“you”] 
Explanation: One possible encode method is: “lint:;code:;love:;you”
```

**Example2**

```
Input: [“we”, “say”, “:”, “yes”] 
Output: [“we”, “say”, “:”, “yes”] 
Explanation: One possible encode method is: “we:;say:;:::;yes”
```

{% tabs %}
{% tab title="Python" %}
```python
class Solution:
    def encode(self, strings):
        res = ""
        for string in strings:
            res += str(len(string)) + '#' + s
        return res
    
    def decode(self, string):
        res = []
        index = 0
        while index < len(string):
            j = index
            while str[j] != '#'
                j += 1
            length = int(string[index : j])
            res.append(string[j + 1 : j + 1 + length])
            index = j + 1 + length
        return res
```
{% endtab %}
{% endtabs %}

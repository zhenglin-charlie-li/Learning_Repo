# 339 Nested List Weight Sum

## 339. Nested List Weight Sum

Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

**Example 1:**

<pre><code><strong>Input: [[1,1],2,[1,1]]
</strong><strong>Output: 10 
</strong><strong>Explanation: Four 1's at depth 2, one 2 at depth 1.
</strong></code></pre>

**Example 2:**

<pre><code><strong>Input: [1,[4,[6]]]
</strong><strong>Output: 27 
</strong><strong>Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
</strong></code></pre>

{% tabs %}
{% tab title="Python Defination" %}
```python
# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
# class NestedInteger:
#    def __init__(self, value=None):
#        """
#        If value is not specified, initializes an empty list.
#        Otherwise initializes a single integer equal to value.
#        """
#
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def add(self, elem):
#        """
#        Set this NestedInteger to hold a nested list and adds a nested integer elem to it.
#        :rtype void
#        """
#
#    def setInteger(self, value):
#        """
#        Set this NestedInteger to hold a single integer equal to value.
#        :rtype void
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """
```
{% endtab %}

{% tab title="Python DFS" %}
```python
class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        def dfs(nestedList: List[NestedInteger], depth: int) -> int:
            ans = 0
            if nestedList is None:
                return 0
            if nestedList.isInteger():
                return depth * nestedList.getInteger()
            else: 
                for eachList in getList():
                    ans += dfs(eachList, depth + 1)
            return ans
        dfs(nestedList, 1)
```
{% endtab %}

{% tab title="Python BFS" %}
```python
class Solution: 
    def depthSum(self, nestedList):
        stack = []
        for nestedInteger in nestedList:
            stack.append((1, nestedInteger))

        ans = 0
        while stack:
            depth, current = stack.pop()
            if current.isInteger():
                ans += depth * current.getInteger()
            else:
                lst = current.getList()
                for nestedInteger in lst:
                    stack.append((depth+1, nestedInteger))

        return ans
```
{% endtab %}
{% endtabs %}

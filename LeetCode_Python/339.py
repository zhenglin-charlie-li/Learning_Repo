# Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
#
# Each element is either an integer, or a list -- whose elements may also be integers or other lists.
#
# Example 1:
#
# Input: [[1,1],2,[1,1]]
# Output: 10
# Explanation: Four 1's at depth 2, one 2 at depth 1.
#
# Example 2:
#
# Input: [1,[4,[6]]]
# Output: 27
# Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
import collections
from typing import List


# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
class NestedInteger:
    def __init__(self, value=None):
        """
        If value is not specified, initializes an empty list.
        Otherwise initializes a single integer equal to value.
        """
        if value is None:
            self.value = []
        else:
            self.isInteger = True
            self.value = [value]

    def isInteger(self):
        """
        @return True if this NestedInteger holds a single integer, rather than a nested list.
        :rtype bool
        """
        return self.isInteger

    def add(self, elem):
        """
        Set this NestedInteger to hold a nested list and adds a nested integer elem to it.
        :rtype void
        """
        self.value.append(elem)

    def setInteger(self, value):
        """
        Set this NestedInteger to hold a single integer equal to value.
        :rtype void
        """
        if self.isInteger:
            self.value = [value]
        else:
            pass

    def getInteger(self):
        """
        @return the single integer that this NestedInteger holds, if it holds a single integer
        Return None if this NestedInteger holds a nested list
        :rtype int
        """
        return self.value[0] if self.isInteger else None

    def getList(self):
        """
        @return the nested list that this NestedInteger holds, if it holds a nested list
        Return None if this NestedInteger holds a single integer
        :rtype List[NestedInteger]
        """
        return self.value if not self.isInteger else None



class Solution:
    def depthSum(self, nestedList):
        stack = []
        for nestedInteger in nestedList.getList():
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


# test
# nestedList = [[1,1],2,[3,3]]
nestedList1 = NestedInteger()
nestedList1.add(NestedInteger(1))
nestedList1.add(NestedInteger(1))
nestedList2 = NestedInteger(2)
nestedList3 = NestedInteger()
nestedList3.add(NestedInteger(3))
nestedList3.add(NestedInteger(3))
nestedList = NestedInteger()
nestedList.add(nestedList1)
nestedList.add(nestedList2)
nestedList.add(nestedList3)
ans = Solution().depthSum(nestedList)
print(ans)

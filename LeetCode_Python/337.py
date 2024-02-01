# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from functools import lru_cache
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    @lru_cache(maxsize=None)
    def rob(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        val = root.val

        if root.left:
            val += self.rob(root.left.left) + self.rob(root.left.right)

        if root.right:
            val += self.rob(root.right.left) + self.rob(root.right.right)

        return max(val, self.rob(root.left) + self.rob(root.right))

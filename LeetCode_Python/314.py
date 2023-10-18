import collections
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    list = []

    def dfs(self, root, level, x) -> None:
        if root is None:
            return
        self.list.append((root.val, level, x))
        self.dfs(root.left, level + 1, x - 1)
        self.dfs(root.right, level + 1, x + 1)

    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        self.dfs(root, 0, 0)
        self.list.sort(key=lambda x: (x[2], x[1], x[0]))
        res = []
        for i in range(0, len(res)):
            sub_level = [element for element, level, x in res if x == i]
        return res

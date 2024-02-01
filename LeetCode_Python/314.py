import collections
from typing import Optional, List


class TreeNode:
    def __init__(self, val: object = 0, left: object = None, right: object = None) -> object:
        self.val = val
        self.left = left
        self.right = right


class Solution:
    list = []

    def dfs(self, root, level, x) -> None:
        pass

    def verticalTraversal1(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        dict_x = collections.defaultdict(list)
        min_x = float('inf')
        max_x = float('-inf')
        # node, level, x
        queue = collections.deque()
        queue.append((root, 0, 0))
        while queue:
            level_size = len(queue)
            for i in range(level_size):
                node, level, x = queue.popleft()
                min_x = min(min_x, x)
                max_x = max(max_x, x)
                dict_x[x].append(node.val)

                if node.left:
                    queue.append((node.left, level + 1, x - 1))
                if node.right:
                    queue.append((node.right, level + 1, x + 1))
        return [dict_x[x] for x in range(min_x, max_x + 1)]

    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        dict_x = collections.defaultdict(list)
        # node, level, x
        queue = collections.deque()
        queue.append((root, 0))
        while queue:
            node, x = queue.popleft()
            dict_x[x].append(node.val)

            if node.left:
                queue.append((node.left, x - 1))
            if node.right:
                queue.append((node.right, x + 1))
        return [dict_x[x] for x in sorted(dict_x.keys())]


# root = [3,9,20,null,null,15,7]
node9 = TreeNode(9)
node15 = TreeNode(15)
node7 = TreeNode(7)
node20 = TreeNode(20, node15, node7)
node3 = TreeNode(3, node9, node20)
root = node3
print(Solution().verticalTraversal(root=root))

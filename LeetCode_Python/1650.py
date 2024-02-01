class Node:
    def __init__(self, val=0, left=None, right=None, parent=None):
        self.val = val
        self.left = left
        self.right = right
        self.parent = parent


class Solution:
    def lowestCommonAncestor(self, root: Node, left: Node, right: Node) -> Node:
        if not root:
            return None
        a, b = left, right
        while a != b:
            a = a.parent if a.parent else right
            b = b.parent if b.parent else left
        return a

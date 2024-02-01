from typing import Optional

class Node:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def insert(self, head: 'Optional[Node]', insertVal: int) -> 'Node':
        if not head:
            new_head = head
            new_head.next = new_head
            return new_head

        cur = head
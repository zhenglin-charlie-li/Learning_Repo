from collections import deque
from typing import List


class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        queue = deque()
        visited = set()
        visited.add((0, 0))
        N = len(grid)
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1), (1, 1), (-1, -1), (1, -1), (-1, 1)]

        queue.append((0, 0, 1))

        def valid(grid, i, j):
            return i >= 0 and i < N and j >= 0 and j < N and (i, j) not in visited and grid[i][j] == 0

        while queue:
            r, c, l = queue.popleft()
            if r == N - 1 or c == N - 1:
                return l + 1
            for r_diff, c_diff in directions:
                r_new = r + r_diff
                c_new = c + c_diff
                if valid(grid, r_new, c_new):
                    visited.add((r_new, c_new))
                    queue.append((r_new, c_new, l + 1))

        return -1


Solution().shortestPathBinaryMatrix([[0, 0, 0], [1, 1, 0], [1, 1, 0]])

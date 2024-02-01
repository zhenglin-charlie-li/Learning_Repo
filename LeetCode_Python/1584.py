import heapq
from typing import List


def minCostConnectPoints(points: List[List[int]]) -> int:
    def manhattan_distance(p1, p2):
        return abs(p1[0] - p2[0]) + abs(p1[1] - p2[1])

    if not points:
        return 0

    # Prim's MST Algorithm
    visited = set()
    priority_queue = []
    min_cost = 0

    heapq.heappush(priority_queue, (0, 0))  # distance, point_index

    while len(visited) < len(points):
        # if not priority_queue:
        #     break

        cost, i = heapq.heappop(priority_queue)
        if i in visited:
            continue

        min_cost += cost
        visited.add(i)

        for j in range(len(points)):
            if j not in visited:
                heapq.heappush(priority_queue, (manhattan_distance(points[i], points[j]), j))

    return min_cost


if __name__ == '__main__':
    print(minCostConnectPoints([[0, 0], [2, 2], [3, 10], [5, 2], [7, 0]]))
    print(minCostConnectPoints([[3, 12], [-2, 5], [-4, 1]]))
    print(minCostConnectPoints([[0, 0], [1, 1], [1, 0], [-1, 1]]))
    print(minCostConnectPoints([[-1000000, -1000000], [1000000, 1000000]]))
    print(minCostConnectPoints([[0, 0]]))

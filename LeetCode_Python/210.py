from collections import defaultdict


class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        graph = defaultdict(list)
        res = []

        def buildGraph():
            for course, prere in prerequisites:
                from_, to_ = prere, course
                graph[from_].append(to_)

        buildGraph()

        visited = set()
        onPath = set()

        def dfs(course):
            if course in onPath:
                return False
            if course in visited:
                return True
            visited.add(course)
            onPath.add(course)
            for neigber in graph[course]:
                if dfs(neigber) == False:
                    return False
            onPath.remove(course)
            res.append(course)
            return True

        for i in range(numCourses):
            if dfs(i) == False:
                return []

        return res[::-1]

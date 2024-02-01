def solution(bubbles, operations):
    rows = len(bubbles)
    cols = len(bubbles[0])

    def pop_bubble(x, y, color):
        if x < 0 or x >= rows or y < 0 or y >= cols:
            return

        if bubbles[x][y] == color:
            bubbles[x][y] = 0

            # Check diagonal neighbors
            for dx in [-1, 0, 1]:
                for dy in [-1, 0, 1]:
                    if dx == 0 and dy == 0:
                        continue
                    pop_bubble(x + dx, y + dy, color)

    for operation in operations:
        x, y = operation
        x -= 1  # Adjust coordinates to 0-based indexing
        y -= 1

        if 0 <= x < rows and 0 <= y < cols and bubbles[x][y] != 0:
            color = bubbles[x][y]
            pop_bubble(x, y, color)

        # Drop bubbles down
        for col in range(cols):
            for row in range(rows - 1, 0, -1):
                if bubbles[row][col] == 0:
                    for r in range(row, 0, -1):
                        bubbles[r][col], bubbles[r - 1][col] = bubbles[r - 1][col], bubbles[r][col]

    return bubbles

# Example usage:
bubbles = [
    [1, 1, 1, 4, 3],
    [4, 1, 2, 3, 3],
    [1, 5, 1, 1, 2],
    [4, 3, 2, 2, 4]
]

operations = [[1, 1], [3, 3], [2, 2], [3, 0]]

result = solution(bubbles, operations)
for row in result:
    print(row)

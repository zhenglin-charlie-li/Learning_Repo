def solution(centers):
    collision_count = 0
    hashmap = {}

    for center in centers:
        x, y = center
        potential_collisions = []

        # Collect potential collisions around the center
        for i in range(-2, 3):  # This loop will run 5 times: -2, -1, 0, 1, 2
            for j in range(-2, 3):
                potential_collisions.append((x + i, y + j))

        # Check for actual collisions
        for pc in potential_collisions:
            if pc in hashmap:
                collision_count += hashmap[pc]

        # Add current center to hashmap
        center_tuple = tuple(center)
        if center_tuple in hashmap:
            hashmap[center_tuple] += 1
        else:
            hashmap[center_tuple] = 1

    return collision_count

# Example usage:
centers = [[1, 1], [2, 2], [0, 4]]
print(solution(centers))  # Expected output: 2

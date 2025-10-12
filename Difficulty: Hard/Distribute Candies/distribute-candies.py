'''
class Node:
    def __init__(self, val):
        self.data = val
        self.right = None
        self.left = None
'''

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

class Solution:
    def solve(self, root, moves):
        if root is None:
            return 0
        l = self.solve(root.left, moves)
        r = self.solve(root.right, moves)
        total_extra_candies = (l + r + root.data) - 1
        moves[0] += abs(l) + abs(r)
        return total_extra_candies
    
    def distCandy(self, root):
        if root is None or (root.left is None and root.right is None):
            return 0
        moves = [0]
        self.solve(root, moves)
        return moves[0]
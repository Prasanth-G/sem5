import pprint
'''
class item:
    def __init__(self, name, weight, profit):
        self.name = name
        self.weight = weight
        self.profit = profit
    def st(self):
        return self.name + ", " + str(self.weight) + ", "+ str(self.profit)
'''


items = [1, 2, 3, 4]
weight = [2, 1, 3, 2]
profit = [12, 10, 20, 15]

il = len(items)
n = 5
P = [[0 for i in range(il + 2)] for i in range(n)]


for i in range(il+1):
    for j in range(n+1):
        if weight[i-1] <= j:
            if (profit[i] + P[i-1][j] - weight[i]) > P[i-1][j]:
                P[i][j] = profit[i] + P[i-1][j - weight[i]]
            else:
                P[i][j] = P[i-1][j]
        else:
            P[i][j] = P[i-1][j]

pprint.pprint(P)

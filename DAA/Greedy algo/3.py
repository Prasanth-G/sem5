import itertools

class job:
    def __init__(self, name, profit, deadline):
        self.name = name
        self.profit = profit
        self.deadline = deadline
    def st(self):
        return self.name + ", " + str(self.profit) + ", "+ str(self.deadline)
name = ['A', 'B', 'C','D', 'E']
profit = [100, 19, 27, 25, 15]
deadline = [2,1,2,1,3]

l = [job(name[i], profit[i], deadline[i]) for i in range(len(name))]

l.sort(key= lambda x: x.profit, reverse=True)

time = 1
for i in range(len(l)):
    each = l[i]
    if each.deadline >= time:
        print(each.st())
        time = time + 1

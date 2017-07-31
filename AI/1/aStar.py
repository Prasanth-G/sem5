import collections
import sys

fscore = {}
neighbours = {'S':['A','B','C'],
              'A':['S','E'],
              'B':['S','E','D'],
              'C':['S','D'],
              'D':['B','C','F'],
              'E':['A','B','F'],
              'F':['G'],
              'G':['F']}
edge_weights = {'SA':6,
                'SB':5,
                'SC':10,
                'AE':6,
                'BE':6,
                'BD':7,
                'CD':6,
                'DF':6,
                'EF':4,
                'FG':3}
heuristic = {'A':10,
             'S':17,
             'B':13,
             'E':4,
             'D':2,
             'G':0,
             'F':1,
             'C':4}

path = collections.defaultdict(set)

def Astar(start, goal):
    closed_set = set()
    open_set = set([start])
    came_from = {}
    gscore = collections.defaultdict(lambda : sys.maxint)
    gscore[start] = 0 
    fscore = collections.defaultdict(lambda : sys.maxint)
    fscore[start] = heuristic[start]
    #visited 
    while open_set:
        current = sorted(open_set, key=lambda x: fscore[x])
        print(current, path)
        current = current[0]
        print(current, closed_set)
        if current == goal:
            return reconstruct_path(came_from, current)

        open_set.remove(current)
        closed_set.add(current)
        
        for each_neighbour in neighbours[current]:
            if each_neighbour in closed_set:
                continue

            if each_neighbour not in open_set:	
                open_set.add(each_neighbour)

            tentative_gscore = gscore[current] + dist_between(current, each_neighbour)
            if tentative_gscore < gscore[each_neighbour]:
                came_from[each_neighbour] = current
                path[each_neighbour].add(current)
                gscore[each_neighbour] = tentative_gscore
                fscore[each_neighbour] = gscore[each_neighbour] + heuristic[each_neighbour]
    return False

def dist_between(nodea, nodeb):
    if nodea + nodeb in edge_weights:
        return edge_weights[nodea+nodeb]
    else:
        return edge_weights[nodeb+nodea]

def reconstruct_path(came_from, current):
    total_path = [current]
    while current in came_from.keys():
        current = came_from[current]
        total_path.append(current)
    total_path.reverse()
    return total_path

path = Astar('S','G')
print(path)

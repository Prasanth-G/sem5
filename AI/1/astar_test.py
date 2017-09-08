'''import sys

graph = {'S' : set(['A', 'B', 'C']),
         'A' : set(['E', 'S']),
         'B' : set(['E', 'D', 'S']),
         'C' : set(['D', 'S']),
         'D' : set(['C', 'B', 'F']),
         'E' : set(['A', 'B', 'F']),
         'F' : set(['E', 'D', 'G']),
         'G' : set(['F'])}
edge_wgt = {'S-A': 6,'S-B': 5,'S-C': 10,'A-E': 6,'B-D': 7,'B-E': 6,'C-D': 6,'D-F': 6,'E-F': 4,'F-G': 3,}
h_n = {'S': 17, 'A': 10, 'B': 13, 'C': 4, 'D': 2, 'E': 4, 'F': 1, 'G': 0}

g_score = {}
for each in 'SABCDEFG':
    g_score[each] = sys.maxsize

f_score = {}
for each in 'SABCDEFG':
    f_score[each] = sys.maxsize 

came_from = {}

def astar(graph, start, destination):
    closed_set = set()
    open_set = set([start])
    f_score[start] = h_n[start]
    
    while open_set:
        open_set = sorted(open_set , key = lambda x: f_score[x])
        current = open_set[0]
        
        if start == destination:
            print("DEST REACHED")
            reconstruct_path(came_from, current)
            break
        del(open_set[0])
        closed_set.append(current)
        for neighbour in graph[current]:
            if neighbour in closed_set:
                continue
            if neighbour not in open_set:
                open_set.append(neighbour)
            g_score[neighbour] = gscore[current]
            if g_score[neighbour] >= gscore[neighbour]:
                continue
            came_from[neighbour] = current
            f_score[neighbour] = g_score[neighbour] + h_n[neighbour]
    return False


def reconstruct_path(cameFrom, current):
    total_path = current
    print(current, came_from)
    while current in came_from.keys:
        current = came_from[current]
        total_path.append(current)
    return total_path


astar(graph, 'S', 'G')
'''

import collections
import sys
import Queue

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

#path = collections.defaultdict(set)

def Astar(start, goal):
    open_queue = Queue.PriorityQueue()
    #closed_set = set()
    came_from = {}
    gscore = collections.defaultdict(lambda : sys.maxint)
    gscore[start] = 0 
    fscore = collections.defaultdict(lambda : sys.maxint)
    fscore[start] = heuristic[start]
    open_queue.put((fscore[start], start))
    #visited
    #path = [start]
    while not open_queue.empty():
        h, current = open_queue.get()
        print(current, open_queue.queue)
        #path.append(current)
        if current == goal:
            return reconstruct_path(came_from, current)

        #closed_set.add(current)
        
        for neighbour in neighbours[current]:
            #if neighbour in closed_set:
             #   continue
            
            tentative_gscore = gscore[current] + dist_between(current, neighbour)
            if tentative_gscore < gscore[neighbour]:
                gscore[neighbour] = tentative_gscore
                fscore[neighbour] = gscore[neighbour] + heuristic[neighbour]
                came_from[neighbour] = current
                if neighbour not in open_queue.queue:
                    open_queue.put(( fscore[neighbour], neighbour))

        #closed_set = set()
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


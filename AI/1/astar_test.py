import sys

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

import Queue
import collections

'''test_case 1'''
graph = {'S' : ['A'],
         'A' : ['S','B','C'],
         'B' : ['D','E'],
         'C' : ['A','F','I'],
         'D' : ['B'],
         'E' : ['B','H','G'],
         'F' : ['C','H'],
         'G' : ['E'],
         'H' : ['E','F'],
         'I' : ['C','H'],}

co_ord = {'S': (1,2),
             'A': (2,3),
             'B': (2,4),
             'C': (2,2),
             'D': (1,4),
             'E': (3,4),
             'F': (3,2),
             'G': (4,4),
             'H': (3,3),
             'I': (3,1)}

'''test_case 2
graph = {'S' : ['A'],
         'A' : ['C'],
         'B' : ['C','E'],
         'C' : ['A','B','D'],
         'D' : ['C','F'],
         'E' : ['B','H'],
         'F' : ['D','H'],
         'G' : ['H'],
         'H' : ['E','F','G']}

co_ord = {'S': (1,2),
             'A': (1,3),
             'B': (2,4),
             'C': (2,3),
             'D': (2,2),
             'E': (3,2),
             'F': (3,1),
             'G': (4,4),
             'H': (4,2)}
'''
def heuristic_function(start_node, goal_node):
    x1, y1 = co_ord[start_node]
    x2, y2 = co_ord[goal_node]
    return (x2 - x1) + (y2 - y1)

def hill_climbing(graph, heuristic_value, start, goal):
    curr = start
    neighbour = collections.defaultdict(Queue.PriorityQueue)
    came_from = {}
    prev = None
    while curr != goal:
        heuristic_curr = heuristic_value(curr, goal)
        #insert all neighbour in a Priority Queue
        for adj_node in graph[curr]:
            h = heuristic_value(adj_node, goal)
            if (h, adj_node) not in neighbour[curr].queue and prev != adj_node:
                neighbour[curr].put((h, adj_node))
        if neighbour[curr].empty():
            return False
        heuristic_child, min_child = neighbour[curr].get()
        if heuristic_curr < heuristic_child:
            #back_tracking
            if curr in came_from:
                prev = came_from[curr]
            else:
                return False
            if neighbour[prev].empty():
                return False
            else:
                _, curr = neighbour[prev].get()
            continue
        came_from[min_child] = curr
        curr = min_child
    return True


start = 'G'
goal = 'S'

print(hill_climbing(graph, heuristic_function, start, goal))

import Queue
import sys
graph = {'a':['b','c'],\
         'b':['d','e'],\
         'c':['l','p'],\
         'd':['b','x','y'],\
         'e':['b'],\
         'p':['c'],\
         'l':['c'],\
         'x':['d'],\
         'y':['d']
         }
graph = {'a':['b','c'],\
         'b':['d','e'],\
         'c':['l','p','g'],\
         'd':['b','g'],\
         'e':['b'],\
         'p':['c'],\
         'l':['c'],\
         'g':['b']
         }

def bfs(source, destination):
    queue = Queue.Queue()
    visited = []
    queue.put(source)
    while not queue.empty():
        curr_node = queue.get()
        print(curr_node)
        if curr_node == destination:
            return True
        visited.append(curr_node)
        for neighbourof in graph[curr_node]:
            if neighbourof not in visited:
                queue.put(neighbourof)
    return False

def dfs(source, destination, limit=sys.maxint, depth=0):
    stack = []
    visited = []
    stack.append(source)
    while stack:
        curr_node = stack.pop()
        print(curr_node)
        if curr_node == destination:
            return True
        if depth > limit:
            return False
        depth = depth + 1
        visited.append(curr_node)
        for neighbourof in graph[curr_node]:
            if neighbourof not in visited:
                stack.append(neighbourof)
    return False

def iterative_deepening_search(source, destination, no_of_iterations):
    for i in range(no_of_iterations):
        print("LEVEL : ", i)
        if dfs(source, destination, i, 0):
            return True
    return False


print("Breath Firest Search : \n")
bfs('a','p')
print('*'*75)
print("Depth First Search : \n")
dfs('a','p')
print('*'*75)
print("Depth Limited Search :\nlimit = 3, depth = 0")
dfs('a','g',3,0)
print("Iterative Deepening Search :\n")
print(iterative_deepening_search('a','d',4))








'''
def dfs(source, destination):
    stack = []
    stack.append(source)
    while stack:
        curr_node = stack.pop()
        print(curr_node)
        if curr_node == destination:
            return True
        for neighbourof in graph[curr_node]:
            if neighbourof not in visited:
                visited.append(curr_node)
                stack.append(neighbourof)
    return False

'''

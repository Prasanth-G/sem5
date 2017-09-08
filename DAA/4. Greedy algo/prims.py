import queue as Queue

def add_edges_to_queue(q, edge_weight, node, neighbour):
    for each in neighbour:
        edge = node + each
        if edge in edge_weight:
            q.put((edge_weight[edge], (node, each)))
        else:
            q.put((edge_weight[each+node], (node, each)))

def prim(adj_list, edge_weight, start_node=None):
    '''adj_list - adjecency list representaion of a graph
       edge_weight - dictionary with vertex pair as key and their edge weight as value
    '''
    if not start_node:
        start_node = list(adj_list.keys())[0]
    temp = {}
    for key in edge_weight:
        temp[key[0]+key[1]] = edge_weight[key]
    edge_weight = temp
    #print(edge_weight)
    vt = []
    et = []
    q = Queue.PriorityQueue()
    vt.append(start_node)
    add_edges_to_queue(q, edge_weight, start_node, adj_list[start_node])
    min_cost = 0
    edges = []
    for i in range(1,len(adj_list)):
        weight, (u, v) = q.get()
        while (u,v) in edges or (v,u) in edges:
            weight, (u,v) = q.get()
        #print("INSERTe",u,v)
        edges.append((u, v))
        neigh = adj_list[v]
        #print("NEIGH: ", neigh, u)
        #if u in neigh:
        #    neigh.remove(u)
        add_edges_to_queue(q, edge_weight, v, neigh)
        min_cost = min_cost + weight
    return (min_cost, edges)
'''
adj_list = {'1':['2','3','4'],
         '2':['1','3','5'],
         '3':['1','2','4','6'],
         '4':['1','3','6'],
         '5':['2','6'],
         '6':['3','4','5']}

edge_weight = {'14':5 ,'12':10 ,'13': 7,'23': 9,'34':13 ,'25':12 ,'56':8 ,'46':11 ,'36':6 }

print(prim(adj_list, edge_weight, '2'))
'''

'''
adj_list = {'1':['2','3','4'],
         '2':['1','3','5'],
         '3':['1','2','4','6','3'],
         '4':['1','3','6'],
         '5':['2','6','3'],
         '6':['3','4','5']}

#edge_weight = {'14':7 ,'12':2 ,'13': 3,'23': 5,'34':6 ,'25':13 ,'56':11 ,'46':12 ,'36':8, '35': 9}
edge_weight = {('2', '5') : 13,
('1', '3') : 3,
('1', '2') : 2,
('1', '4') : 7,
('2', '3') : 5,
('4', '6') : 12,
('5', '6') : 11,
('3', '6') : 8,
('3', '5') : 9,
('3', '4') : 6}
'''
def kruskal(adj_list, edge_weight):
    parent = {}
    for each in adj_list:
        parent[each] = each
    sorted_edge_weight = sorted(edge_weight, key=lambda a: edge_weight[a])
    edges = []
    count = 0
    min_weight = 0
    while len(edges) != len(adj_list):
        c = sorted_edge_weight[count]
        u, v = c
        #print(c)
        count = count + 1
        i = parent[u]
        j = parent[v]
        if i != j:
            #print(u, v, parent)
            parent[i] = j
            edges.append((u,v))
            min_weight = min_weight + edge_weight[c]
    return (min_weight,edges)
'''
print(kruskal(adj_list, edge_weight))
'''

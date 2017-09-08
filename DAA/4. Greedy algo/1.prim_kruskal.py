import pprint
import prims
import kruskal


graph = {'H1' : ['H2','H3','H10'],
         'H2' : ['H1','H3','H10','H5','H8'],
         'H3' : ['H1','H2','H4'],
         'H4' : ['H3','H5','H6'],
         'H5' : ['H2','H4','H6','H8'],
         'H6' : ['H4','H5','H7','H9'],
         'H7' : ['H6','H8'],
         'H8' : ['H2','H5','H7','H9','H10'],
         'H9' : ['H6','H8'],
         'H10' : ['H1','H2','H8']}

edge_weight = {('H2', 'H10') : 30,
               ('H2', 'H5') : 25,
               ('H1', 'H3') : 45,
               ('H6', 'H9') : 40,
               ('H2', 'H3') : 30,
               ('H8', 'H9') : 45,
               ('H6', 'H5') : 75,
               ('H6', 'H4') : 40,
               ('H3', 'H4') : 45,
               ('H8', 'H2') : 100,
               ('H8', 'H10') : 50,
               ('H8', 'H5') : 90,
               ('H8', 'H7') : 15,
               ('H2', 'H1') : 20,
               ('H5', 'H4') : 75,
               ('H1', 'H10') : 45,
               ('H6', 'H7') : 80}

print("Prim's :")
pprint.pprint(prims.prim(graph, edge_weight, 'H8'))
print("Kruskal :")
pprint.pprint(kruskal.kruskal(graph, edge_weight))
'320'
a = '''Chicago Pizza
Dominos
Little Caesars
New York Pizza
Pizza Hut
Straw Hat'''

table_name = "PIZZERIA"
cmd = 'INSERT INTO ' + table_name + " VALUES (\'%s\');"


import pprint
r = [each.split('\t') for each in a.split('\n')]
#pprint.pprint(r)
#print(cmd)
for each in r:
    print(cmd%tuple(each))

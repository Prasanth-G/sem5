a = '''s1	p1	300	.005
s1	p2	200	.009
s1	p3	400	.004
s1	p4	200	.009
s1	p5	100	.01
s1	p6	100	.01
s2	p1	300	.006
s2	p2	400	.004
s3	p2	200	.009
s3	p3	200	NULL
s4	p2	200	.008
s4	p3	NULL	NULL
s4	p4	300	.006
s4	p5	400	.003'''
table_name = "SHIPMENT"
cmd = 'INSERT INTO ' + table_name + " VALUES (\'%s\', \'%s\', %s, %s);"


import pprint
r = [each.split('\t') for each in a.split('\n')]
#pprint.pprint(r)

for each in r:
    print(cmd%tuple(each))

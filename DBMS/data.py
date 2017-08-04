a = '''Arul	Developer	17000	M	21-apr-66	10-jun-86	Banking	7806745231
Anand	Programmer	15000	M	11-sep-75	17-jun-97	Retail	null
Ilamathi	System Analyst	21000	M	07-feb-66	21-apr-91	Retail	7806745229
Deepak	Programmer	12000	M	14-feb-67	21-sep-90	Ecommerce	7806745230
Elavarasi	System Analyst	22000	F	23-mar-70	21-apr-86	Banking	7806745232
Juliana	Programmer	12000	F	14-jul-70	21-mar-89	Banking	null
Kamala	Programmer	12000	F	14-jul-66	04-mar-90	Finance	7806745233
Nelson	Project Leader	25000	M	27-jun-69	07-sep-90	Ecommerce	7806745234
Palani	System Analyst	20000	M	29-apr-62	21-sep-93	MobileApp	7806745235
Ramesh	Programmer	17000	M	21-apr-66	12-oct-93	MobileApp	7806745236
Revathi	Programmer	20000	F	21-apr-70	14-dec-99	MobileApp	7806745237
Xavier	Programmer	20000	M	21-apr-71	12-mar-97	Ecommerce	7806745238
Vijaya	Developer	17000	F	21-apr-72	21-sep-94	Ecommerce	7806745239'''
table_name = "EMPLOYEE"
cmd = 'INSERT INTO ' + table_name + " VALUES (\'PSG%d\', \'%s\', DEFAULT, \'%s\', %s, \'%s\', %s, %s, \'%s\', %s );"


import pprint
r = [each.split('\t') for each in a.split('\n')]
#pprint.pprint(r)

count = 100
for each in r:
    print(cmd%tuple([count]+each))
    count = count + 1

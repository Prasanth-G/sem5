'''locations = [300, 350, 400, 500, 750, 790, 810, 900, 950, 1100, 1150, 1180, 1210, 1300, 1450, 1550, 1771, 1801, 1901, 2250]

l = [locations[0]]
for i in range(len(locations)-1):
    l.append(locations[i+1] - locations[i])

s = locations[0]
for i in range(1, len(l)):
	s = s + l[i]
	if s > 400:
		print(locations[i-1])
		s = l[i]


##################or'''
locations = [300, 350, 400, 500, 750, 790, 810, 900, 950, 1100, 1150, 1180, 1210, 1300, 1450, 1550, 1771, 1801, 1901, 2250]

distance = 400
for i in range(1, len(locations) - 1):
	if locations[i+1] > distance:
		print(locations[i])
		distance = distance + 400


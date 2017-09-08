import collections

file = open("data.txt")
data = file.read()
count = collections.Counter(data)
desc_order = sorted(count, key=lambda x: count[x], reverse = True)
print(desc_order)

file_ = open('data.txt')
file_.close()
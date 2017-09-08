#a = [1,1,1,2,2,5,6,6,7,7,8,9,9,10]
#a = [1,5,6,7,8,9]
a = [1,2,3,17,10]

k = 1
for i in range(len(a)):
    each = a[i]
    max_ele = each + 4
    if i + k < len(a):
        while max_ele > a[i + k]:
            k = k + 1
print(k)
#a = [1,2,3,17,10,4]
a = [1,2,3,4,9,10,15,17,18,19,20,21]
#a = [1, 3, 4, 6, 7]
'''for i in range(len(a)):
    for j in range(len(a)):
        if a[i] < a[j]:
            a[i], a[j] = a[j], a[i]
'''
a.sort()
k = 1
for i in range(len(a)):
    each = a[i]
    start = each
    end = each + 4
    if k + i < len(a):
        while a[i + k] <= end:
            k = k + 1
            if i + k > len(a) - 1:
                break

print(len(a) - k + 1)

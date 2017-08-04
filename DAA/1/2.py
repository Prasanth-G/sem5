n_ = int(input('Enter Initial number of sacks : '))
print("Enter No. of cobs in each sacks ");
arr = [int(input(str(i+1)+" : ")) for i in range(n_)]
sum_ = sum(arr)
n = 1
while sum_ > (n*(n+1))/2:
    n = n + 1
if sum_ != (n*(n+1))/2:
    print("Can't arrange the cobs in order")
else:
    expected_output = [i for i in range(1,n+1)]
    while expected_output != arr:
        temp = [each-1 for each in arr] + [len(arr)]
        print(temp)
        arr = temp
        while 0 in arr:
            arr.remove(0)
        #print(arr)

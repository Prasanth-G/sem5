
def max_crossing_subarray(arr, low, mid, high):
    left_sum = arr[mid]
    max_left = mid
    sum_ = 0
    for i in range(mid , low-1, -1):
        #print("1",i)
        sum_ = sum_ + arr[i]
        if sum_ > left_sum:
            left_sum = sum_
            max_left = i
    right_sum = arr[mid+1]
    max_right = mid+1
    sum_ = 0
    for i in range(mid+1, high+1, 1):
        #print("2",i)
        sum_ = sum_ + arr[i]
        if sum_ > right_sum:
            right_sum = sum_
            max_right = i
    return (max_left, max_right, left_sum + right_sum)

def max_subarray(arr, low, high):
    if high == low:
        return (low, high, arr[high])
    else:
        mid = (low + high)// 2
        left_low, left_high, left_sum = max_subarray(arr, low, mid)
        right_low, right_high, right_sum = max_subarray(arr, mid+1, high)
        cross_low, cross_high, cross_sum = max_crossing_subarray(arr, low, mid, high)
        if left_sum >= right_sum and left_sum >= cross_sum:
            return (left_low, left_high, left_sum)
        elif right_sum > left_sum and right_sum >= cross_sum:
            return (right_low, right_high, right_sum)
        else:
            return (cross_low, cross_high, cross_sum)

a = [13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7]
print(max_subarray(a, 0, len(a)-1))

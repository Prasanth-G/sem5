import itertools
import math

p = [(1,2), (3,5), (6,3), (4,8), (7,11)]

xcoord = lambda a: a[0]
ycoord = lambda a: a[1]
eu = lambda x: eu_dist(x[0], x[1])

def closest_pair(p):
    px = sorted(p, key=xcoord)
    py = sorted(p, key=ycoord)
    return closest_pair_recursive(px, py)

def eu_dist(x, y):
    return math.sqrt(((x[1] - y[1])**2) + ((x[0] - y[0])**2))

def closest_pair_recursive(px, py):
    #print(px , py)
    if len(px) <= 3 :
        px_comb = [a for a in itertools.permutations(px, 2)]
        py_comb = [b for b in itertools.permutations(py, 2)]
        m = min([min(px_comb, key= eu), min(py_comb, key=eu)], key=eu)
        return m
    else:
        xnby2 = len(px)/2
        QX = px[:xnby2]
        RX = px[xnby2:]

        ynby2 = len(py)/2
        QY = py[:ynby2]
        RY = py[ynby2:]
        qx, qy = closest_pair_recursive(QX, QY)
        rx, ry = closest_pair_recursive(RX, RY)
        deltap = min([(qx,qy), (rx,ry)], key=eu)
        delta = eu_dist(deltap[0], deltap[1])
        xstar = max(QX, key=xcoord)
        l1 = xstar[0] - delta
        l2 = xstar[0] + delta
        s = set()
        for each in px+py:
            if each[0] > l1 and each[0] < l2:
                s.add(each)
        s = list(s)
        s.sort(key=ycoord)
        temp = [[s[i], eu_dist(s[i], s[0])] for i in range(1,len(s))]
        minsyp, minsy = min(temp, key= lambda x: x[1])
        if minsy < delta:
            return (minsyp, s[0])
        else:
            #print(deltap)
            return deltap
        
print("Ans: ", closest_pair(p))

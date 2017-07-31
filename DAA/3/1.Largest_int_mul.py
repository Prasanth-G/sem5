import math
def multiply(x ,y):
    sx = str(x)
    sy = str(y)
    lenx = len(sx)
    leny = len(sy)
    if lenx == 1 or leny == 1:
        return x*y
    else:
        if lenx > leny:
            sy = sy.zfill(lenx)
        elif leny > lenx:
            sx = sx.zfill(leny)
        if lenx % 2:
            sy = sy.zfill(lenx+1)
            sx = sx.zfill(lenx+1)
        n = len(sx)
        n2 = n/2
        xl = int(sx[:n2])
        xr = int(sx[n2:])
        yl = int(sy[:n2])
        yr = int(sy[n2:])
        p0 = multiply(xr, yr)
        p1 = multiply(xl + xr, yl + yr)
        p2 = multiply(xl, yl)
        temp = (p2* (10**n)) + ((p1 - p0 - p2)*(10**math.ceil(float(n)/2))) + p0
        print(sx, sy, temp)
        return temp

x = raw_input('X : ')
y = raw_input('Y : ')
'''
x = '471233'
y = '743343'
x = 6345
y = 43
'''
print('%s X %s = %d'%(x,y,multiply(x, y)))

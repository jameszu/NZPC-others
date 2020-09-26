dp = [[]]
path = [[]]
def vis(j, i, k):
    while j >0 and path[j][k] != i:
        k -= v[path[j][k]]
        j -= 1
    return j
T = input().split()
while T != ['0', '0']:
    n = int(T[0])
    m = int(T[1])
    v = []
    s = []
    idx = []
    for i in range(1, n+1):
        line = input().split()
        a = int(line[0])
        b = int(line[1])
        v += [a-b]
        s += [a+b]
    
    dp = [[-1]*810]*21
    path = [[0] * 810]*21
    fix = m * 20
    dp[0][fix] = 0
    for j in range(1, m+1):
        for k in range(fix*2+1):
            if (dp[j-1][k] >= 0):
                for i in range(1, n+1):

                    if dp[j][k+v[i]]<dp[j-1][k]+s[i]:
                        if not vis(j-1, i, k):
                            dp[j][k+v[i]] = dp[j-1][k] + s[i]
                            path[j][k+v[i]] = i
    for k in range(fix+1):
        if dp[m][fix-k] != -1 or dp[m][fix+k] != -1:
            break

    minv, maxs = 0, 0
    if dp[m][fix-k] <dp[m][fix+k]:
        minv = fix +k
        maxs = dp[m][fix+k]
    else:
        minv = fix-k
        maxs = dp[m][fix-k]

    maxD = (minv + maxs - fix) //2
    maxP = (maxs - minv + fix) //2

    ii = 1
    jj = m
    kk = minv
    while j >0:
        idx[i] = path[j][k]
        k -= v[idx[i]]
        j -= 1
        i += 1
    idx.sort()
    print(idx)
    T = input().split()

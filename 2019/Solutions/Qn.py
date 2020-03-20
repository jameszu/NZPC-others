line1=input().split()
N=int(line1[0])
Q=int(line1[1])
line2=input().split()
for i in range(len(line2)):
    line2[i]=int(line2[i])
d={}
for i in range(len(line2)):
    d[i]=line2[i]
Queries=[]
for i in range(Q):
    a=input().split()
    for i in range(2):
        a[i]=int(a[i])
    Queries.append(a)

results=[]
ref={}
for query in Queries:
    a=query[0]
    count=0
    flag=query[0]
    while True:
        a=d[a]
        count += 1
        if a==flag:
            results.append(query,-1)
            #ref[query[0]]=[a,count]
            break
        if a==query[1]:
            results.append(count)
            #ref[query[0]]=[a,count]
            break
        # if a in ref:
        #     a=ref[a][0]
        #     count+=ref[a][1]
for result in results:
    print(result)




# 5 2
# 1 0 1 4 3
# 2 0
# 3 1
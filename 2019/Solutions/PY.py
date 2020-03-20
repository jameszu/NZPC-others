import sys

L=[]
#f=open('test.txt','r')
for line in sys.stdin:
    L.append(line.split()[0])
#print(L)

sum=0
for i in range(0,len(L)-1):
    
    sum+=int(L[i])
    if i!= len(L)-2:
        sys.stdout.write('N = {:<6} Partial Sum = {}'.format(L[i], sum))
        sys.stdout.write('\n')
    else:
        sys.stdout.write('N = {:<6} Final Sum = {}'.format(L[i], sum))
    

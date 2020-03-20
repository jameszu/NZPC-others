num = int(input())
A = input().split()
key=int(A[0])
count=0
import sys

def equal(A,B):
    if len(A)!=len(B):
        for i in range(len(B)):
            if int(A[i])!=int(B[i]):
                return True
    for i in range(len(A)):
        if int(A[i])!=int(B[i]):
            return False
    return True

flag=False
for i in range(1,num):
    if int(A[i])==key:
        count+=1
        if count//2==(count+1)//2: #count is even
            seq=A[:i]
            half1=seq[:len(seq)//2]
            half2=seq[len(seq)//2:]
            if equal(half1,half2):
                print(len(half1))
               # for item in half1:
                #    sys.stdout.write(item+' ')
                flag=True
                break
if not flag:
    print(num)
    #for item in A:
     #   sys.stdout.write(item+' ')



# for P in range(1, num):
#     count = 0
#     for i in range(num-P):
#
#
#         if A[i+P] != A[i]:
#             break
#         else:
#             count += 1
#
#     if count == num - P - 1:
#         print(P)
# print(count)
# 6
# 42 100 99 42 42 100
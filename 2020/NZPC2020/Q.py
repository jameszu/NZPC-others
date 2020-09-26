# T = int(input())
# count = 0
# for _ in range(T):
# 	N = int(input())
# 	A = input().split()
# 	A = [int(x) for x in A]
# 	counter =  0
# 	largest = -1
# 	for i in range(N-1):
# 		if (A[i] > largest):
# 			largest = A[i]
# 			if (A[i] > A[i+1]):
# 				counter += 1
# 	if A[N-1] > largest:

# 		counter += 1
# 	print("Case #{}: {}".format(_+1, counter), flush = True)

# T = int(input())
# count = 0
# while T != 0:
# 	lst = []
# 	for _ in range(T):
# 		N = input()
# 		lst += [N]
# 	final = set(lst)
# 	out = len(final)
# 		# counter =  0
		
# 	print("Week {} {}".format(count+1, out), flush = True)
# 	count += 1
# 	T = int(input())

T = input()
lst = T.split()
for i in lst:
	print(i[::-1], end=" ")

# Rewrite from sample answer, still encounter 1 second time limit error
import math
num = int(input())
diff = 0
count = 0
comp = [False for i in range(num)]
for i in range(2, math.ceil(math.sqrt(num))):
	if comp[i]:
		continue
	j = i*i
	while j < num:
		comp[j] = True
		j += i
prime_list = []
for i in range(2, num):
	if (not comp[i]):
		prime_list += [i]

while (num>2):
	for x in prime_list:
		if (not comp[num - x]):
			num -= 2* x
			count += 1
			break
print(count)
# Time limit error occurred (1 sec)
# while num >= 3:
# 	prime_list = []

# 	nNew = int((num - 2) / 2)
# 	marked = [0] * (nNew + 1)
# 	for i in range(1, nNew + 1): 
# 		j = i; 
# 		while((i + j + 2 * i * j) <= nNew): 
# 			marked[i + j + 2 * i * j] = 1
# 			j += 1; 
# 	if (num > 2): 
# 		prime_list += [2]
# 	for i in range(1, nNew + 1): 
# 		if (marked[i] == 0): 
# 			prime_list += [2 * i + 1]

# 	k = 0
# 	while (prime_list[k] <= num //2):
# 		diff = num - prime_list[k]
# 		if diff in prime_list:
# 			num = diff - prime_list[k]
# 			break
# 		k += 1
# 	count += 1
# print(count)
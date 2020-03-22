rights = int(input())
my_ans = input()
fri_ans = input()
out = 0
ans_length = len(fri_ans)
temp = 0
match = 0
j = 0
index = 0
# for i in range(len-1):
# 	if my_ans[i] == fri_ans[i]:
# 		match += 1

for i in range(ans_length-3):
	index = i
	j=0
	if (index + rights > ans_length):
		break
	else:
		while (j < rights):
			if my_ans[index] == fri_ans[index]:
				temp += 1
			index += 1
			j += 1
	for i in range(ans_length-3, ans_length-1):
		if my_ans[i] != fri_ans[i]:
			temp += 1
	if temp > out:
		out = temp

	temp = 0
print(out)
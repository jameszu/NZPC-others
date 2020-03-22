n = int(input())
l,r = [],[]
for i in range(n):
	li,ri = map(int, input().split())
	l.append(li)
	r.append(ri)

for j in range(n,-1,-1):
	c = sum(a<=j<=b for a,b in zip(l,r))
	if c == j:
		print (j)
		break
else:
	print (-1)
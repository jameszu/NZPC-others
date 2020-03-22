string = list(map(int,string.split()))
nrow = stirng[0]
ncol = string[1]
cells = []
drains = [[0 for i in range(ncol)] for j in range(nrow)]

for i in range(nrow):
	row = input()
	row = list(map(int, row.split()))
	cells.append(row)

for r in range(1, nrow-1):
	for c in range(1, ncol-1):
		if drainOrNot(cells, r, c):
			drains[r][c] = 1

for i in range(nrow):
	for j in range(ncol):
		print(drain[i][j])

	print('\n')
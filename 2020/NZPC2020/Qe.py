T = input()

first_line = T.split()
if len(first_line) < 2:
    print()
n = int(first_line[0])
d = int(first_line[1])
r1 = int(input())
r2 = int(input()) 

lst1 = [x for x in range(1, n+1)]
lst2 = [y for y in range(n, 0, -1)]
if r1 != 0:
    del lst1[r1-1]
if r2 != 0:
    del lst2[r2-1]

for i in range(d):
    line = input().split()
    line_lst = [int(x) for x in line]
    choice1 = line_lst[0] -1
    choice2 = line_lst[1] -1
    outfit1 = lst1[choice1]
    outfit2 = lst2[choice2]
    if outfit1 == outfit2:
        print("Day {} ALERT".format(i+1), flush = True)
    else:
        print("Day {} OK".format(i+1), flush = True)


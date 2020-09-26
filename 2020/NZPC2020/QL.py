

first_line = input().split()
while first_line != ['0', '0']:

    p = int(first_line[0])
    d = int(first_line[1])
    lst = []
    for i in range(p):
        cord = input().split()
        lst += [(float(cord[0]), float(cord[1]))]
    print(lst)
    first_line = input().split()

# 8 150
# 100 100
# 400 100
# 240 100
# 300 100
# 240 60.0
# 240 30.0
# 300 130
# 300 160
# 8 150
# 100 100
# 400 100
# 240 100
# 300 100
# 240 60.0
# 240 30.0
# 300 130
# 300 160
# 0 0
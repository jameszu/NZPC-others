import math
string = input()
list1 = string.split()
x = int(list1[0])
y = int(list1[1])
x1 = int(list1[2])
y1 = int(list1[3])
x2 = int(list1[4])
y2 = int(list1[5])
out = 0
if (x <= x1 and y >= y2):
	out = math.sqrt((x1 - x) ** 2 + (y2-y) **2)
elif (x1<x<x2 and y >= y2):
	out = abs(y-y2)
elif (x >= x2 and y >= y2):
	out = math.sqrt((x2 - x) ** 2 + (y2-y) **2)

elif (x >= x2 and y1<=y<=y2):
	out = abs(x-x2)
elif (x >= x2 and y <= y1):
	out = math.sqrt((x2-x)**2 + (y1-y)**2)
elif (x1<x<x2 and y <= y1):
	out = abs(y-y1)
elif (x<=x1 and y <= y1):
	out = math.sqrt((x1-x)**2 + (y1-y)**2)
elif (x<=x1 and y1<=y<=y2):
	out = abs(x-x1)
else:
	out = 0
print("{:.3f}".format(out))


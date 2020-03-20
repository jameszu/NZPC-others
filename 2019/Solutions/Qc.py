name = input()
numbers = int(input())
need ={}
have={}
import sys

def convert(tuple):
    if tuple[1]=='kg':
        tuple[0]=tuple[0]*1000
        tuple[1]='g'
    if tuple[1]=='l':
        tuple[1]=='ml'
        tuple[0]==tuple[0]*1000
    return tuple

def Failure(l):
    print('You may NOT make your {}.'.format(name))
    sys.stdout.write('You need ')
    for item in l[:-1]:
        sys.stdout.write('{}, '.format(item))
    sys.stdout.write('{}.'.format(l[-1]))



for index in range(numbers):
    line = input().split(', ')
    value=[float(line[2]),line[1]]
    value=convert(value)
    need[line[0]] = value
for index in range(numbers):
    line = input().split(', ')
    value=[float(line[2]),line[1]]
    value=convert(value)
    have[line[0]] = value

l=[]
for key in need.keys():
    if key in have:
        if have[key]<need[key]:
            l.append(key)
    if key not in have:
        l.append(key)
if len(l)==0:
    print('You may make your {}.'.format(name))
else:
    l.sort()
    Failure(l)

# Basic butter cake
# 4
# butter, g, 200
# caster sugar, g, 200
# eggs, x, 4
# self raising flour, g, 200
# eggs, x, 10
# butter, g, 500
# self raising flour, kg, 1.5
# caster sugar, g, 450

# Honey-glazed ham
# 6
# ham, kg, 2
# honey, ml, 150
# orange juice, ml, 75
# soy sauce, ml, 18
# allspice, ml, 6
# ground cloves, ml, 3
# orange juice, ml, 0
# allspice, ml, 17
# ham, kg, 1
# honey, ml, 250
# ground cloves, ml, 8
# soy sauce, ml, 25
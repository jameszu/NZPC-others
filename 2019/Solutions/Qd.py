name1 = input()
name2 = input()
scores = input().split()
name1_score = int(scores[0])
name2_score = int(scores[1])
N = int(input())
strokes = input()
L=[]
j=0
for i in range(N):
    if strokes[i]=='M' or strokes[i]=='P':
        L.append(strokes[j:i+1])
        j=i+1
L.append(strokes[j:])

for string in L[::2]:
    for char in string:
        if char=='H' or char=='P':
            name1_score+=1
for string in L[1::2]:
    for char in string:
        if char=='H' or char=='P':
            name2_score+=1

print('{} {} {} {}'.format(name1,name1_score,name2,name2_score))
# Sam and Tom
# Trish & Kathy
# 3 12
# 27
# RCRCHRCHRCHRCMMRCRPHRCRCRCH
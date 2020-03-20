w = input().split()
S = int(input())
stud=[]
for i in range(S):
    stud.append(input().split())
results=[]

a = input()
while a!='0 # #':
    a=a.split()
    results.append(a)
    a = input()


times={}
scores={}
weights={'A':int(w[0]),'B':int(w[1]),'C':int(w[2]),'D':int(w[3]),'E':int(w[4])}
for person in stud:
    times[person[0]]={'A':0,'B':0,'C':0,'D':0,'E':0}
    scores[person[0]]=0
for result in results:
    times[result[0]][result[1]]+=1
    if result[2]=='P':
        if times[result[0]][result[1]]==1:
            scores[result[0]]+=10*weights[result[1]]
        elif times[result[0]][result[1]]==2:
            scores[result[0]]+=7*weights[result[1]]
        else:
            scores[result[0]]+=4*weights[result[1]]
passmark=(int(w[0])+int(w[1])+int(w[2])+int(w[3])+int(w[4]))*5
for person in stud:
    if scores[person[0]]>=passmark:
        print(person[1] +' '+ person[2] +" Pass")
    else:
        print(person[1]+' '+person[2]+ " Fail")



# 1 1 2 3 3
# 4
# 1206 Angela Williamson
# 1244 Barry Read
# 3564 Josephine Henry
# 2272 Thomas Hansen
# 3564 A P
# 1206 C F
# 1244 B F
# 3564 C F
# 1244 B F
# 1244 D F
# 2272 A F
# 1206 B F
# 2272 B F
# 1206 E P
# 2272 A P
# 1244 A P
# 1206 D P
# 3564 D P
# 1244 C P
# 2272 C F
# 1244 D P
# 3564 C F
# 2272 C P
# 3564 B P
# 3564 C P
# 1244 B F
# 2272 E F
# 2272 B P
# 1206 A F
# 1206 B P
# 2272 E P
# 0 # #

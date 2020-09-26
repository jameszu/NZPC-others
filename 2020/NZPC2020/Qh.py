def sum_factors(n):  
     result = []
     for i in range(1, int(n**0.5) + 1):
         if n % i == 0:
            result.extend([i, n//i])
     return sum(set(result)-set([n]))

def amicable_pair(start, end):
    result = []
    for x in range(start ,end+1):
        y = sum_factors(x)
        if sum_factors(y) == x and x != y:
            result += sorted([x, y])
    
    return list(dict.fromkeys(result))


N = int(input())

for i in range(N):
    range_lst = input().split()
    start = int(range_lst[0])
    to = int(range_lst[1])
    res = amicable_pair(start, to)
    print("Amicable numbers between {} and {}".format(start, to))
    if len(res) == 0:
        print("None")
    else:
        for i in res:
            print(i, end=" ")

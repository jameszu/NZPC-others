number = int(input())
count = 0
def lcm(A,B):
    for num in range(1, int(B)):
        prod1 = num * A
        if prod1 % B != 0:
            continue
        else:
            return prod1
    return 61

def right(A, B):
    freqA = 60/A
    freqB = 60/B
    the_lcm = lcm(freqA, freqB)
    if the_lcm >= 60:
        return 1
    else:
        the_right = 60 // the_lcm
        return the_right

for i in range(1, number):
    wrong = number - i
    rights = right(number, i)
    if wrong == rights:
        count += 1
        #print(number - wrong)

print(count)
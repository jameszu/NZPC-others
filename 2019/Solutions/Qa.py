park_number = int(input())
first_day = input()
second_day = input()
count = 0
for index in range(park_number):
    if first_day[index] == 'O':
        if second_day[index] == 'O':
            count += 1

print(count)
# 5
# OO-OO
# -OO--
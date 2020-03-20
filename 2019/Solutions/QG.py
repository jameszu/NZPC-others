num = int(input())
for i in range(num):
    line = input()
    line_list = line.split()
    index = 0
    for index in range(len(line_list)-1):
        if line_list[index] == '+':
            answer = int(line_list[index-2]) + int(line_list[index-1])
            line_list = [line_list[:index-2], [answer], line_list[index+1:]]
            index -= 1
        elif line_list[index] == '-':
            answer = int(line_list[index-2]) - int(line_list[index-1])
            line_list = [line_list[:index-2], [answer], line_list[index+1:]]
            index -= 1

        elif line_list[index] == '*':
            answer = int(line_list[index-2]) * int(line_list[index-1])
            line_list = [line_list[:index-2], [answer], line_list[index+1:]]
            index -= 1
            print(line_list, index)

        elif line_list[index] == '/':
            answer = int(line_list[index-2]) // int(line_list[index-1])
            line_list = [line_list[:index-2], [answer], line_list[index+1:]]
            index -= 1

        else:
            continue
print(line_list)
# 3
# 3 4 2 * +
# 2 9 5 + * 3 –
# 17 10 + 3 * 9 /
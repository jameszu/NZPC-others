num1 = int(input())
num2 = int(input())
import math
sum = num1 + num2
minus = num1 - num2
product = num1 * num2
int_div = int(num1 / num2)

# if num1<0 or num2<0 and (num1>0 or num2>0):
#     int_div=-int_div
remain = num1 -num2*int_div




print('{} + {} = {}'.format(num1, num2, sum))
print('{} - {} = {}'.format(num1, num2, minus))
print('{} x {} = {}'.format(num1, num2, product))
print('{} divided by {} is {} remainder {}'.format(num1, num2, int_div, remain))
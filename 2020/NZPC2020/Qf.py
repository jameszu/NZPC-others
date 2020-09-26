class Stack:
    """ Last in first out"""
    def __init__(self):
        self.items = []
    def is_empty(self):
        return self.items == []
    def peek(self):
        return self.items[len(self.items - 1)]
    def push(self,item):
        return self.items.append(item)
    def pop(self):
        return self.items.pop()
    def size(self):
        return len(self.items)

def HTMLCheck(line):
    # How to see if << is covered

    stack = Stack()
    list1 = list()

    list1 = line.split()
    index = 0
    while index < len(list1):
        for ch in list1[index]:
            if ch == '<':
                stack.push(ch)
            elif ch == '>':
                if stack.is_empty():
                    return False
                else:
                    stack.pop()
        index += 1

    return stack.is_empty() # if the stack is not empty then it was not balanced ...
T = input()

while T != "#":
    res = HTMLCheck(T)
    T = input()
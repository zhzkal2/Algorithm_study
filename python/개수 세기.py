n = int(input())

numbers = list(map(int, input().split()))

m = int(input())

count = 0

for i in numbers:
    if i == m:
        count += 1
print(count)

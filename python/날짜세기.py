E, S, M = map(int, input().split())

result = 1

while True:
    if (E - result) % 15 == 0 and (S - result) % 28 == 0 and (M - result) % 19 == 0:
        print(result)
        break
    result += 1

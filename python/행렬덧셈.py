rows, cols = map(int, input().split())

matrix1 = []
matrix2 = []
result = []
for _ in range(rows):
    row = list(map(int, input().split()))
    matrix1.append(row)


for _ in range(rows):
    row = list(map(int, input().split()))
    matrix2.append(row)

for i in range(rows):
    result_row = []
    for j in range(cols):
        result_row.append(matrix1[i][j] + matrix2[i][j])
    result.append(result_row)

for row in result:
    print(" ".join(map(str, row)))


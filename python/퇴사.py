# 백준 14501번 퇴사
import sys

N = int(input())

schedule = [list(map(int, sys.stdin.readline().split())) for i in range(N)]


# print(schedule)  # 테스트 코드

dp = [0 for i in range(N + 1)]

# i를 기준으로 얻는 최대 수익 계산
for i in range(N):
    #  i번째 날에 상담을 진행했을때 기준을 dp[j]에 저장
    for j in range(i + schedule[i][0], N + 1):
        if dp[j] < dp[i] + schedule[i][1]:
            dp[j] = dp[i] + schedule[i][1]

print(dp[-1])

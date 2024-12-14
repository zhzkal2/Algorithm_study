package kotlin_algo

import java.util.*

fun main() {
    // n * m 입력 받기
    val (n, m) = readln().split(" ").map { it.toInt() }

    // 다음 n줄 입력 받기
    val maze = Array(n) {
        readln().map { it.digitToInt() }.toIntArray()
    }

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    fun bfs(): Int {
        val queue = LinkedList<Pair<Int, Int>>()
        queue.add(Pair(0, 0))

        val dist = Array(n) { IntArray(m) { -1 } }  // -1로 초기화
        dist[0][0] = 1  // 시작 칸은 1번째 칸으로 설정

        while (queue.isNotEmpty()) {
            val (x, y) = queue.poll()

            // 네 방향으로 탐색
            for (i in 0 until 4) {
                val nextX = x + dx[i]
                val nextY = y + dy[i]

                // 범위 체크 및 이동 가능 칸 확인
                if (nextX in 0 until n && nextY in 0 until m && maze[nextX][nextY] == 1 && dist[nextX][nextY] == -1) {
                    dist[nextX][nextY] = dist[x][y] + 1
                    queue.add(Pair(nextX, nextY))
                }
            }
        }
        return dist[n - 1][m - 1]

    }
    println(bfs())


}
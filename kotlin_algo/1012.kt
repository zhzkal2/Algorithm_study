package kotlin_algo

fun countCabbageGroups(n: Int, m: Int, cabbagePositions: List<Pair<Int, Int>>): Int {
    // 코틀린은 카멜케이스로 작성이 기본이다.
    // val field = Array(m){booleanArray(n)} 오류발생
    val field = Array(m) { BooleanArray(n) }


    cabbagePositions.forEach { (x, y) -> field[y][x] = true }



    val dx = listOf(0, 0, -1, 1)
    val dy = listOf(-1, 1, 0, 0)

    val visited = Array(m) { BooleanArray(n) }


    var groupCount = 0


    fun dfs(x: Int, y: Int) {
        //수정가능한 리스트 생성
        val stack = mutableListOf(Pair(x, y))
        //무한 루프 방지
        visited[y][x] = true
        while (stack.isNotEmpty()) {
            val (cx, cy) = stack.removeAt(stack.size - 1)
            for (i in 0 until 4) {
                val nx = cx + dx[i]
                val ny = cy + dy[i]

                if (nx in 0 until n && ny in 0 until m && !visited[ny][nx] && field[ny][nx]) {
                    visited[ny][nx] = true
                    stack.add(Pair(nx, ny))
                }
            }

        }


    }


    for (y in 0 until m) {
        for (x in 0 until n) {
            if (field[y][x] && !visited[y][x]) {
                dfs(x, y)
                groupCount++
            }
        }
    }
    return groupCount


}






fun main() {

    val testCaseCount = readln().toInt()

    val results = mutableListOf<Int>()

    //배추가로길이 M
    //배추세로길이 N
    //배추가 심어진 위치 K
    repeat(testCaseCount) {
        val (n, m, k) = readln().split(" ").map { it.toInt() }

//        println("n = $n  m = $m  k = $k")

        val cabbagePositions = mutableListOf<Pair<Int, Int>>()
        repeat(k) {
            val (x, y) = readln().split(" ").map { it.toInt() }
            cabbagePositions.add(Pair(x, y))
        }
        results.add (countCabbageGroups(n, m, cabbagePositions))


    }

    results.forEach{result ->println(result)}


}


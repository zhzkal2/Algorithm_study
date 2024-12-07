fun main() {

    fun beeline_check(p1: Pair<Int, Int>, p2: Pair<Int, Int>, p3: Pair<Int, Int>): Boolean  {
        return (p2.second - p1.second) * (p3.first - p2.first) == (p3.second - p2.second) * (p2.first - p1.first)
    }

    val points = Array<Pair<Int, Int>>(3) { Pair(0, 0) }

    repeat(3) { i->
        val (x, y) = readln().split(" ").map { it.toInt() }
        points[i] = Pair(x, y)
    }

    val result = beeline_check(points[0], points[1], points[2])


    println(if (result) "WHERE IS MY CHICKEN?" else "WINNER WINNER CHICKEN DINNER!")





}


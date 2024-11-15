package kotlin_algo

import java.util.*


var house_dis = mutableListOf<Int>()  // 이동 시간 리스트 전역 변수로 선언
var house_cost = mutableListOf<Int>()  // 마스크 생산 비용 리스트 전역 변수로 선언


fun main() {


    //집의 갯수
    val house = readln().toInt()

    house_cost = readln().split(" ").map { it.toInt() }.toMutableList()

    house_dis = readln().split(" ").map { it.toInt() }.toMutableList()


    val task = readln().toInt()

    repeat(task) {
        val input = readln().split(" ")
        val command = input[0]
        val num1 = input[1].toInt()
        val num2 = input[2].toInt()

        when (command) {
            "CALL" -> {
//                println("CALL $num1 $num2")
                call(num1, num2)
            }

            "UPDATE" -> {
//                println("UPDATE $num1 $num2")
                update(num1, num2)
            }

            else -> {
                println("error")
            }
        }
    }


}

fun update(num1: Int, num2: Int) {

    house_dis[num1 - 1] = num2

}

fun call(num1: Int, num2: Int) {
    //num1 = 현재 위치
    //num2 최소 사용가능한 거리 코스트

    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
    val visited = BooleanArray(house_cost.size) // 방문한 집을 추가로 방문하지 않기 위해서 조건문의 변수
    var minCost = house_cost[num1 - 1]

    pq.add(Pair(house_cost[num1 - 1], num1 - 1))  // 시작 집 val1 비용 val2 위치

    var totalTime = 0  // 이동 시간 초기화


    visited[num1 - 1] = true //시작집이므로 방문한것으로 취급


    while (pq.isNotEmpty()) {
        val (cost, house) = pq.poll()

        // 현재 집의 최소 비용을 갱신
        if (cost < minCost) minCost = cost

        // 왼쪽 집으로 이동 (이전 집)
        if (house > 0 && !visited[house - 1] && totalTime + house_dis[house - 1] <= num2) {
            visited[house - 1] = true
            totalTime += house_dis[house - 1]  // 이동 시간 갱신
            pq.add(Pair(house_cost[house - 1], house - 1))  // 큐에 집 추가
            totalTime = 0
        }


        // 오른쪽 집으로 이동 (다음 집)
        if (house < house_cost.size - 1 && !visited[house + 1] && totalTime + house_dis[house] <= num2) {
            visited[house + 1] = true
            totalTime += house_dis[house]  // 이동 시간 갱신
            pq.add(Pair(house_cost[house + 1], house + 1))  // 큐에 집 추가
        }
    }
    println(minCost)

}




package kotlin_algo

fun main() {
    val friends = arrayOf("muzi", "ryan", "frodo", "neo")
    val gifts = arrayOf(
        "muzi frodo",
        "muzi frodo",
        "ryan muzi",
        "ryan muzi",
        "ryan muzi",
        "frodo muzi",
        "frodo ryan",
        "neo muzi"
    )
    //예상 결과 result = 2
    val result = solution(friends, gifts)

    println(result)


}
//메모장 대신
//

fun solution(friends: Array<String>, gifts: Array<String>): Int {

    var answer: Int = 0

    //2중배열 생성
    val giftMap = Array(friends.size) { IntArray(friends.size) }

    for (gift in gifts) {
        val (giver, receiver) = gift.split(" ")
        val giverIndex = friends.indexOf(giver)
        val receiverIndex = friends.indexOf(receiver)
        giftMap[giverIndex][receiverIndex]++
    }

    val giftScores = IntArray(friends.size) { i ->
        val given = giftMap[i].sum()  // 준 선물
        val received = giftMap.sumOf { it[i] }  // 받은 선물
        given - received  // 선물 지수
    }
    val nextMonthGifts = IntArray(friends.size)


    for (i in friends.indices) {
        for (j in i + 1 until friends.size) {
            val iToJ = giftMap[i][j]  // i가 j에게 준 선물
            val jToI = giftMap[j][i]  // j가 i에게 준 선물

            when {
                iToJ > jToI -> nextMonthGifts[i]++  // i가 선물 받음
                iToJ < jToI -> nextMonthGifts[j]++  // j가 선물 받음
                else -> {  // 선물을 주고받지 않았거나 같은 수로 주고받은 경우
                    when {
                        giftScores[i] > giftScores[j] -> nextMonthGifts[i]++
                        giftScores[i] < giftScores[j] -> nextMonthGifts[j]++
                    }
                }
            }
        }
    }


    return nextMonthGifts.maxOrNull() ?: 0
}

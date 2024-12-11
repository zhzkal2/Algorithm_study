package kotlin_algo

fun main() {
    val record = arrayOf(
        "Enter uid1234 Muzi",
        "Enter uid4567 Prodo",
        "Leave uid1234",
        "Enter uid1234 Prodo",
        "Change uid4567 Ryan"
    )

    println(solution(record).joinToString("\n"))
}

fun solution(record: Array<String>): Array<String> {
    val userMap = mutableMapOf<String, String>()  // uid -> nickname
    val result = ArrayList<String>()
    record.forEach { r ->
        val (action, uid, nickname) = r.split(" ").plus("")
        if (action != "Leave") {
            userMap[uid] = nickname
        }

    }


     record.forEach { r ->
        val (action, uid) = r.split(" ")
        when (action) {
            "Enter" -> result.add("${userMap[uid]}님이 들어왔습니다.")
            "Leave" -> result.add("${userMap[uid]}님이 나갔습니다.")
            else -> null
        }
    }
    return result.toTypedArray()
}
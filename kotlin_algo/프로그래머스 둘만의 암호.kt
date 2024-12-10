fun solution(s: String, skip: String, index: Int): String {
    
        var answer: String = ""


        repeat(s.length) { i ->

                var current = s[i]
                var count = 0
        

        while (count < index) {
            current++
            // z를 넘어가면 a로 돌아가기
            if (current > 'z') {
                current = 'a'
            }
            // skip에 포함된 문자는 건너뛰고 카운트하지 않음
            if (current !in skip) {
                count++
            }
        }
        answer += current
        }




    return answer
}

fun main() {
    val s = "aukks"
    val skip = "wbqd"
    val index = 5

    println(solution(s, skip, index))
}


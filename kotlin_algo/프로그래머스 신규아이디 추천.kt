package kotlin_algo

import java.util.*


fun main() {
    val newId = "z-+.^."
    println(solution(newId))
}

fun solution(newId: String): String {

    var answer = newId

    // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    if (isValidId(answer)) {
        return answer
    }
    answer = answer.lowercase(Locale.getDefault())

    // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    if (isValidId(answer)) {
        return answer
    }
    answer = answer.filter { it.isLowerCase() || it.isDigit() || it == '-' || it == '_' || it == '.' }
    // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    if (isValidId(answer)) {
        return answer
    }
    while (answer.contains("..")) {
        answer = answer.replace("..", ".")
    }

    // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    if (isValidId(answer)) {
        return answer
    }
    answer = answer.trimStart('.')
    answer = answer.trimEnd('.')

    // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    if (isValidId(answer)) {
        return answer
    }
    if (answer.isEmpty()) {
        answer = "a"
    }

    // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
    if (isValidId(answer)) {
        return answer
    }
    if (answer.length >= 16) {
        answer = answer.substring(0, 15).trimEnd('.')
    }

    // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
    if (isValidId(answer)) {
        return answer
    }
    while (answer.length <= 2) {
        answer += answer.last()
    }

    return answer
}

//아이디의 길이는 3자 이상 15자 이하여야 합니다.
fun checkLength(id: String): Boolean {
    return id.length in 3..15
}

// 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표 사용 가능
fun checkValidCharacters(id: String): Boolean {
    return id.all { it.isLowerCase() || it.isDigit() || it == '-' || it == '_' || it == '.' }
}

// 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
fun checkDot(id: String): Boolean {
    return !id.startsWith(".") && !id.endsWith(".") && !id.contains("..")
}

fun isValidId(id: String): Boolean {
    return checkLength(id) &&
            checkValidCharacters(id) &&
            checkDot(id)
}

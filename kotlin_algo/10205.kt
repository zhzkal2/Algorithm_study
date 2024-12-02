package kotlin_algo

fun main() {
    //대문자를 사용하는건 권장하는 문법이 아니므로 T => t
    val t = readln().toInt()

    repeat(t) {index ->
        var result = readln().toInt()
        val str = readln()

        for (char in str) {
            if (char == 'b') {
                result -= 1
            } else if (char == 'c') {
                result += 1
            }

            if (result == 0) {
                break
            }
        }

        println("Data Set ${index + 1}:")
        println(result)
        if (index < t - 1) {
            print("\n")
        }

    }
}


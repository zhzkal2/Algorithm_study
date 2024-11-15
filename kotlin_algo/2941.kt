package kotlin_algo

fun main() {
    val word = readln()
    var count = 0
    val croatianAlphabets = listOf("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=")
    var processedWord = word

    for (alphabet in croatianAlphabets) {

        processedWord = processedWord.replace(alphabet, "X")

    }

    println(processedWord.length)


}


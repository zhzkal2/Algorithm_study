package kotlin

fun main(){
    val (a, b) = readln().split(" ").map { it.toInt() }

    val result = a+b

    val n = readln().toInt()

    val result2 = readln().split(" ").take(n).map { it.toInt() }.sorted()



    println(result)
    println(result2.joinToString(" "))

}
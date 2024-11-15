package kotlin

fun main(){
    val (a, b) = readln().split(" ").map { it.toLong() }

    val result = (a+b) * (a-b)

    println(result)


}
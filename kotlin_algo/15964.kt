package kotlin_algo

fun main(){
    val (a, b) = readln().split(" ").map { it.toLong() }

    val result = (a+b) * (a-b)

    println(result)


}
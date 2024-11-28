package kotlin_algo

fun main(){

    val (n1, n2, n12) = readLine()!!.split(" ").map { it.toInt() }

    val N = ((n1+1).toLong() * (n2+1).toLong())/(n12+1).toLong()  -1

    println(N.toInt())

}
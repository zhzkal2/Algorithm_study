package kotlin_algo

fun main() {
    val (n, h, v) = readln().split(" ").map { it.toInt() }

    val thickness = 4

    val vol1 = h * v * thickness
    val vol2 = h * (n - v) * thickness
    val vol3 = (n - h) * v * thickness
    val vol4 = (n - h) * (n - v) * thickness

    println(maxOf(vol1, vol2, vol3, vol4))
}


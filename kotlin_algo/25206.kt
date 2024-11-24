package kotlin_algo

fun main() {

    val gradeToPoint = mapOf(
        "A+" to 4.5,
        "A0" to 4.0,
        "B+" to 3.5,
        "B0" to 3.0,
        "C+" to 2.5,
        "C0" to 2.0,
        "D+" to 1.5,
        "D0" to 1.0,
        "F" to 0.0
    )
    var totalPoints = 0.0;
    var totalCredits = 0.0

    repeat(20) {
        val input = readLine() ?: return
        val parts = input.split(" ")

        if (parts.size == 3) {
            val credits = parts[1].toDouble()
            val grade = parts[2]

            if (grade != "P") {
                val gradePoint = gradeToPoint[grade] ?: 0.0
                totalPoints += credits * gradePoint
                totalCredits += credits
            }

        }


    }

    println("%.6f".format(totalPoints / totalCredits))
}

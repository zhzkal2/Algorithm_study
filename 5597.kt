// 5597 과제 안내신 분..?
fun main(){

    val allStudents = (1..30).toSet()

    val submittedStudents = mutableSetOf<Int>()

    repeat(28){
        val number = readLine()!!.toInt()
        submittedStudents.add(number)
    }

    val notSubmitted = allStudents - submittedStudents


    val result = notSubmitted.sorted()
    println(result[0])
    println(result[1])
}
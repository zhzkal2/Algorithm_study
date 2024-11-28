package kotlin_algo

fun main(){

    val n = readln().toInt()
    val arrayA = readLine()!!.split(" ").map { it.toInt() }.sorted()
    val m = readLine()!!.toInt()
    val queries = readLine()!!.split(" ").map { it.toInt() }

    fun binarySearch(taget:Int):Int{
        var low =0
        var high = arrayA.size - 1

        while (low<=high){
            val mid = low + (high - low) / 2
            when{
                arrayA[mid] ==taget ->{
                    return 1}
                arrayA[mid] <taget ->{
                    low = mid+1
                }
                else->{
                    high = mid - 1
                }
            }
        }

        return 0
    }

    val result = queries.map { binarySearch(it) }

    println(result.joinToString("\n"))


}
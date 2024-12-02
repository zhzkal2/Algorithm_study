import java.time.LocalDate

class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        
        //[2022,05,19] [0,1,2]
        val todayDate = today.split(".").map { it.toInt() }
        var answer: IntArray = intArrayOf()
        val answerList = mutableListOf<Int>()
        var count = 1
        
        

        //associate가 무엇인가?
        // 각 요소를 Pair(키-값 쌍)로 변환합니다
        // to 키워드로 Pair를 생성합니다
        // 결과는 Map입니다
        // 키가 중복되면 마지막 값이 유지됩니다
        // set과 비슷하지만 여러개있으면, 마지막 값은 유지됩니다.
        
        val termsMap = terms.associate { term ->
        val (type, month) = term.split(" ")
        type to month.toInt()}
        
        
        val privaciesMap = privacies.associate{ privacy ->
        val (delete, teramday) = privacy.split(" ")
        var temp = delete.split(".").map { it.toInt() }.toMutableList()
        //2021.05.02 temp
        temp[1] =(temp[1] + termsMap.getValue(teramday))
        temp[0]= temp[0] +  (temp[1] - 1) / 12
        temp[1]= (temp[1] - 1) % 12 + 1

        println(temp)
        val date1 = LocalDate.of(todayDate[0], todayDate[1], todayDate[2])
        val date2 = LocalDate.of(temp[0], temp[1], temp[2])

        val compare = date1.compareTo(date2)
        if (compare>=0){
            answerList.add(count)
        }
        count++
            
        delete to termsMap[teramday]
        
        }

        
    
        return answerList.toIntArray()
    }
}
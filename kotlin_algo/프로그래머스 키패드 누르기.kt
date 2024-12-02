class Solution {
    
    //중앙 2,5,8,0 버튼을 누르기 위해 절대값 계산
    fun calculateDistance(position1: Pair<Int, Int>, position2: Pair<Int, Int>): Int {
    return Math.abs(position1.first - position2.first) + Math.abs(position1.second - position2.second)
    }
    
    
    fun solution(numbers: IntArray, hand: String): String {
    
        //오른손잡이인지 왼손잡이인지 체크후 변환
    val used_hand = when(hand) {
        "right" -> "R"
        else -> "L"    
    }

        
        
    val keypad = mapOf(
        1 to Pair(0, 0), 2 to Pair(0, 1), 3 to Pair(0, 2),
        4 to Pair(1, 0), 5 to Pair(1, 1), 6 to Pair(1, 2),
        7 to Pair(2, 0), 8 to Pair(2, 1), 9 to Pair(2, 2),
        0 to Pair(3, 1), '*' to Pair(3, 0), '#' to Pair(3, 2)
    )


    var leftPosition = keypad['*']!!
    var rightPosition = keypad['#']!!

    //문자열 조작할 때 사용할 수 있음 append 사용가능
    val result = StringBuilder()


    for(number in numbers) {
        when(number){
            //1,4,7번의 경우 왼손
            1,4,7->{
                result.append("L")
                leftPosition = keypad[number]!!

            }
            //3,6,9의 경우 오른손
            3,6,9->{
                result.append("R")
                rightPosition = keypad[number]!!
            }
            //중앙 버튼
            else->{
                val target = keypad[number]!!
                val leftDistance = calculateDistance(leftPosition, target)
                val rightDistance = calculateDistance(rightPosition, target)
                
                //절대값을 통해서 왼손 오른손 체크
                if(leftDistance < rightDistance){
                    
                    result.append("L")
                    leftPosition = target
                }else if(leftDistance > rightDistance){
                    result.append("R")
                    rightPosition = target
                }else{
                    //거리가 같을 경우 used_hand로 처리
                    result.append(used_hand)
                    if(used_hand == "R"){
                        rightPosition = target
                    }else{
                        leftPosition = target
                    }


                }
            }
        }
    }

    return result.toString()
    
    }
}
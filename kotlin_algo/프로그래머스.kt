fun main(){

    var board = [[0,0,0,0,0],
                [0,0,1,0,3],
                [0,2,5,0,1],
                [4,2,4,4,2],
                [3,5,1,3,1]]

    val moves = [1,5,3,5,1,2,1,4]

    val boardSize = board.size
    var answer = 0
    val basket = mutableListOf<Int>()

    for (move in moves) {

        val col = move - 1

        for (row in board.indices) {
            if(board[row][col] != 0){
                val doll = board[row][col]
                board[row][col] = 0

                //스택형태로 들어오므로 라스트와 같으면 삭제
                if(basket.isNotEmpty() && basket.last() == doll){
                    basket.removeAt(basket.size - 1)
                    answer += 2
                }else{
                    basket.add(doll)
                }

                break
        

            }
        }
    }

    return answer
}
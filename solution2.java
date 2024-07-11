//         프로그래머스 Lv2 최솟값 만들기
//         처음 작성할 때의 생각 : 
//         A를 오름차순 정렬을 하고 B를 내림차순 정렬을 하려고 하였다.
//         내림차순 정렬은 기본 타입배열은 사용할 수 없으므로 객체타입 배열로 변경하고 진행하였지만
//         B 내림차순으로 정렬하고 다시 map을 이용해서 B에 다시 적용시키는 방법을 사용하였다.
//         이 경우 시간초과가 발생
//         1차수정 : map을 삭제하고 BInteger를 사용해서 계산을 했다.
//         이 경우에도 시간초과가 발생
//         2차 수정 parallelSort를 사용하여 내림차순으로 정렬을 한다.
//         배열의 크기가 매우 큰 경우 Arrays.parallelSort를 사용하여 정렬을 성능을 향상시킬 수 있다.
//         하지만 배열의 크기가 작은 경우는 기본 정렬보다 느릴 수 있기에 테스트가 필요하다.
//         시간초과의 경우 정렬의 성능의 향상만으로 해결되지 않을까 싶어서
//         정렬의 초점을 두고 다시 정렬을 하여 정답을 구했습니다.
        


import java.util.Arrays;
import java.util.Collections;

class Solution
{
    public int solution(int []A, int []B)
    {
        
        int answer = 0;

// 첫번째 시도        
//         // A를 오름차순으로 정렬
//         Arrays.sort(A);

//         //B를 내림차순으로 정렬
//         Integer[] BInteger = Arrays.stream(B).boxed().toArray(Integer[]::new);
//         Arrays.sort(BInteger, Collections.reverseOrder());

        
//         for(int i = 0; i<A.length; i++){
//             answer += A[i]*BInteger[i];
//         }
//         return answer;
        
        // A와 B를 병렬 정렬
        Arrays.parallelSort(A);
        Arrays.parallelSort(B);
        
        // 정렬된 배열을 순서대로 곱하고 합계 계산
        int n = A.length;
        for (int i = 0; i < n; i++) {
            answer += A[i] * B[n - 1 - i]; // B를 역순으로 접근
        }

        return answer;
    } 

}

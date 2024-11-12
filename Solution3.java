//프로그래머스 Lv2 올바른 괄호
import java.util.Stack;

public class Solution3 {
    boolean solution(String s) {
        
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' ) {
                stack.push(c); // 왼쪽 괄호는 스택에 push
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false; // 스택이 비어있으면 올바르지 않은 괄호
                }
                char top = stack.pop(); // 스택에서 pop하여 짝이 맞는지 확인
                if (c == ')' && top != '(') 
                    return false; // 짝이 맞지 않으면 올바르지 않은 괄호
                }
            }
            return stack.isEmpty(); // 모든 문자열을 순회한 후 스택이 비어있어야 올바른 괄호
        }
        
}

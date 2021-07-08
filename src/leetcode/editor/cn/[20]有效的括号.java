package leetcode.editor.cn;


//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1862 👎 0

import java.util.Stack;

//import leetcode.editor.util.*;
class ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        String s = "([]){})";
        boolean b = solution.isValid(s);
        System.out.println(b);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length() ; i++) {
            if(c[i] == '('){
                stack.push(')');
            }else if (c[i] == '['){
                stack.push(']');
            }else if (c[i] == '{'){
                stack.push('}');
            }else if(stack.isEmpty()|| (char)stack.peek() != c[i]){
                return false;
            }else{
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
package leetcode.editor.cn;

//给定一个字符串，逐个翻转字符串中的每个单词。 
//
// 
//
// 示例 1： 
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
// 
//
// 示例 2： 
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 
//
// 说明： 
//
// 
// 无空格字符构成一个单词。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 
//
// 进阶： 
//
// 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。 
// Related Topics 字符串 
// 👍 217 👎 0

class ReverseWordsInAString{
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAString().new Solution();
        System.out.println(solution.reverseWords("  the sky is blue  "));
//        char[] c = "the sky is blue".toCharArray();
//        solution.reverse(c,0,14);
//        System.out.println(c);

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        char[] t = s.toCharArray();
        char[] c = removeExtraSpaces(t);
        reverse(c,0,c.length -1);
        int start = 0;
        int end = 0;
        boolean entry = false;
        for (int i = 0; i < c.length; i++) {
            if(!entry ||c[i] != ' ' && c[i - 1] == ' ' ){
                start = i;
                entry = true;
            }
            if(entry && c[i]== ' ' && c[i - 1] != ' ' ){
                end = i - 1;
                entry = false;
                reverse(c,start,end);
            }
            if(entry && (i == c.length - 1) && c[i] != ' '){
                end = i;
                entry = false;
                reverse(c,start,end);
            }
        }
        return new String(c);
    }
    public char[] removeExtraSpaces(char[] c){
        int slowIndex = 0;
        int fastIndex = 0;
        while (c.length > 0 && fastIndex < c.length && ' ' == c[fastIndex] ){
            fastIndex++;
        }
        for (; fastIndex < c.length ; fastIndex++) {
            if(fastIndex - 1 > 0 && c[fastIndex] == c[fastIndex - 1] && ' ' == c[fastIndex] ){
                continue;
            }else {
                c[slowIndex++] = c[fastIndex];
            }
        }
        char[] t = null;
        if(--slowIndex > 0 && ' ' == c[slowIndex] ){
            t = new char[slowIndex];
            for (int k = 0; k < slowIndex ; k++) {
                t[k] = c[k];
            }
        }else {
            t = new char[slowIndex + 1];
            for (int k = 0; k < slowIndex + 1 ; k++) {
                t[k] = c[k];
            }
        }
        return t;
    }

    public void reverse(char[] c,int s,int e){
        int m = (e - s +1)/2;
        for (int i = s; i < s + m ; i++) {
            char temp = c[i];
            c[i] = c[e - (i - s)];
            c[e - (i - s)] = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
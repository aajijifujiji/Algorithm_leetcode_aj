package leetcode.editor.cn;

//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。 
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
// Related Topics 字符串 
// 👍 50 👎 0

class ZuoXuanZhuanZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new ZuoXuanZhuanZiFuChuanLcof().new Solution();
        String str = "abcdefg";
        String s = solution.reverseLeftWords(str,2);
        System.out.println(s);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] c = s.toCharArray();
        reverse(c,0,n-1);
        reverse(c,n,c.length-1);
        reverse(c,0,c.length-1);
        return new String(c);
    }
    public void reverse(char[] c,int s ,int e){
        int offset = (e - s + 1)/2;
        for (int i = s; i < s + offset ; i++) {
            char t = c[i];
            c[i] = c[e - (i - s)];
            c[e - i + s] = t;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
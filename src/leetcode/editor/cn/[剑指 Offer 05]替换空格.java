package leetcode.editor.cn;

//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 39 👎 0

class TiHuanKongGeLcof{
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
        String r = solution.replaceSpace("We are happy.");
        System.out.println(r);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        int count = 0;
        int sOldLen = s.length();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length ; i++) {
            if(' ' == c[i])count++;
        }
        char[] t = new char[c.length+count*2];
        for (int i = 0; i < c.length ; i++) {
            t[i] = c[i];
        }
        for (int i = t.length-1,j=c.length-1; i >= 0 ; i--,j--) {
            if(' ' == (c[j])){
                t[i--] = '0';
                t[i--] = '2';
                t[i] = '%';
            }else{
                t[i] = c[j];
            }
        }
        return new String(t);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
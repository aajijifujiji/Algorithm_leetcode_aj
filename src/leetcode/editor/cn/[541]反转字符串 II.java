package leetcode.editor.cn;

//给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例: 
//
// 输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
// 
//
// 
//
// 提示： 
//
// 
// 该字符串只包含小写英文字母。 
// 给定字符串的长度和 k 在 [1, 10000] 范围内。 
// 
// Related Topics 字符串 
// 👍 89 👎 0

class ReverseStringIi{
    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
        String str = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
        String s2 = solution.reverseStr(str,39);
        System.out.println(s2);
//        char[] cha = "0123456789".toCharArray();
//        solution.reverse(cha,3,5);
//        System.out.println(cha);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length ; i += 2*k) {
            if(i + k <str.length){
                reverse(str,i,i+k-1);
                continue;
            }
            reverse(str,i,str.length-1);
        }
        return new String(str);
    }
    public void reverse(char[] str,int s,int e){
        int offset = (e - s + 1) / 2 ;
        for (int i = s,j = e; i < s + offset ; i++,j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
//    public String reverseStr(String s, int k) {
//        String [] str = s.split("");
//        String temp = "";
//        int i = 0;
//        for (; i < str.length; i += 2 * k) {
//            if(i + k <= str.length){
//                int j = i;
//                for (int c = 1; j < i + k / 2; j++,c++) {
//                    temp = str[j];
//                    str[j] = str[i + k - c];
//                    str[i + k - c] = temp;
//                }
//            }else {
//                break;
//            }
//        }
//        int m = i;
//        int l = str.length - i;
//        for (int x = 1; m < i+(str.length - i)/2 ; m++ , x++) {
//            temp = str[m];
//            str[m] = str[i + l - x ];
//            str[i + l - x] = temp;
//        }
//        String r = "";
//        for (int n = 0; n < str.length ; n++) {
//            r += str[n];
//        }
//        return r;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
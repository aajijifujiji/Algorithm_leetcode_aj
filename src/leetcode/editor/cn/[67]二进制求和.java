package leetcode.editor.cn;

//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 位运算 数学 字符串 模拟 👍 794 👎 0

class AddBinary{
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
        String a = "11";
        String b = "1";
//        String s = solution.addBinary(a, b);
        String s = solution.addBinary(null, b);
        System.out.println(s);
    }

class Solution {
    public String addBinary(String a, String b) {
        if(a == null && b == null) {
            return "";
        }
        if(a == null ) {
            return ""+b;
        }
        if(b == null ) {
            return ""+a;
        }

        StringBuffer res = new StringBuffer();
        int lo = Math.max(a.length(), b.length()), carray = 0;// 获取遍历最长的一列
        for (int i = 0; i < lo; i++) {
            carray += a.length() > i? (a.charAt(a.length() - i - 1) - '0') : 0;// 当前位数 字符, 没有就为0
            carray += b.length() > i? (b.charAt(b.length() - i - 1) - '0'): 0;// 当前位数 字符, 没有就为0
            res.append((char) (carray % 2 +'0'));// 判断是否为零
            carray /= 2;
        }
        if (carray > 0) {
            res.append('1');
        }
        res.reverse();
        return res.toString();
    }
}

}
package leetcode.editor.cn;

//给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。 
//
// 例如： 
//
// 
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//... 
//
// 
//
// 示例 1: 
//
// 
//输入: columnTitle = "A"
//输出: 1
// 
//
// 示例 2: 
//
// 
//输入: columnTitle = "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 
//输入: columnTitle = "ZY"
//输出: 701 
//
// 
//
// 提示： 
//
// 
// 1 <= columnTitle.length <= 7 
// columnTitle 仅由大写英文组成 
// columnTitle 在范围 ["A", "FXSHRXW"] 内 
// 
// Related Topics 数学 字符串 👍 328 👎 0

class ExcelSheetColumnNumber{
    public static void main(String[] args) {
        Solution solution = new ExcelSheetColumnNumber().new Solution();
        int aa = solution.titleToNumber("BAA");
        System.out.println(aa);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();

        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = columnTitle.charAt(i);// A, A, B
            System.out.println(c);
            res += (c - 'A' + 1) * (Math.pow(26, n - i - 1));
            System.out.println(res);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
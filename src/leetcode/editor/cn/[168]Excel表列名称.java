package leetcode.editor.cn;

class ExcelSheetColumnTitle{
    public static void main(String[] args) {
        Solution solution = new ExcelSheetColumnTitle().new Solution();
        int num = 701;
        String s = solution.convertToTitle(num);
        System.out.println(s);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuffer str  = new StringBuffer();

        int j;
        while(columnNumber > 0){
            columnNumber--;
            str.append(Character.toChars('A' + columnNumber % 26));
            columnNumber = columnNumber / 26;
        }

    return str.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion

/*
1, 2, 3, 4, 5, ... 24, 25, 26, 27, 28... 52, 53, 54
A, B, C, D, E, ...  X,  Y,  Z, AA, AB... BA, BB, BC
1/26                           多少层, 多少个A
0, 0, 0, 0, 0, ...  0,  0,  0,  1,  1... 2,   2,  2
1*26


A, AA, AAA, AAAA
0-26, 26^1+1 - 26*26, 26*26*1- 26*26*26, 26*26*26*1 + 1 - 26*26*26*26

* */
}
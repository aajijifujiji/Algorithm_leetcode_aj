package leetcode.editor.cn;

//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//] 
// Related Topics 数组 
// 👍 229 👎 0

class SpiralMatrixIi{
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        int[][] ints = solution.generateMatrix(5);
        System.out.println(ints);
        for (int i = 0; i < ints.length ; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(  "   " + ints[i][j]);
            }
            System.out.println("");
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int res [][] =new int[n][n];
        int startx = 0;
        int starty = 0;
        int loop = n/2;
        int mid = n/2;
        int count = 1;
        int offset = 1;
        int i,j;
        while (loop-->0){
            i = startx;
            j = starty;
            for (j = starty; j < starty + n - offset ; j++) {
                res[startx][j] = count++;
            }
            for (i = startx; i < startx + n -offset; i++) {
                res[i][j] = count++;
            }
            for (;j>starty;j--) {
                res[i][j] = count++;
            }
            for (;i>startx;i--) {
                res[i][j] = count++;
            }
            startx++;
            starty++;
            offset +=2;
        }
        if(n % 2 > 0 ){
            res[mid][mid] = count;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
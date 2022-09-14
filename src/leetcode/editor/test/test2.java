package leetcode.editor.test;

/**
 * @Author: aajijifujiji
 * @DATE: 2022/3/15 00:51
 */
public class test2 {
    public static void main(String[] args) {
        int[][] i = new int[3][2];
        for (int j = 0; j < i[0].length; j++) {
            for (int k = 0; k < i.length; k++) {
                i[k][j] = 0;
            }
        }

        int[][] ii = floodFill(i, 0, 0, 1);

    }
    private static int x;
    private static int y;
    private static int oldColor;
    private static int newColor_;
    private static boolean[][] visited;
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        x = image[0].length;
        y = image.length;
        oldColor = image[sr][sc];
        newColor_ = newColor;
        visited = new boolean[y][x];
        sl(image, sr, sc);

        return image;
    }
    public static void sl(int[][] image, int sr, int sc){
        if(sr < 0 || sr > y - 1)return ;
        if(sc < 0 || sc > x - 1)return;
        if(image[sr][sc] != oldColor)return;
        if(visited[sr][sc])return;
        visited[sr][sc] = true;
        image[sr][sc] = newColor_;
        //up
        sl(image, sr, sc - 1);
        sl(image, sr, sc + 1);
        sl(image, sr - 1, sc);
        sl(image, sr + 1, sc);
    }
}

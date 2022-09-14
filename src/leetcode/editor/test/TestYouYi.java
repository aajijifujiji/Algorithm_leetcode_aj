package leetcode.editor.test;

/**
 * @Author: aajijifujiji
 * @DATE: 2022/5/18 23:07
 */
public class TestYouYi {
    public static void main(String[] args) {
        int a = -1, count = 0;
        while(a != 0){
            count += a & 1;
//            a >>>= 1;
            a >>= 1;
        }
        System.out.println(count);

    }
}

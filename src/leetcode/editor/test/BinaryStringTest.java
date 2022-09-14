package leetcode.editor.test;

/**
 * @Author: aajijifujiji
 * @DATE: 2022/6/3 01:37
 */
public class BinaryStringTest {
    public static void main(String[] args) {



        Integer x = 2390;
        int ones = 0;
        while (x > 0) {
            System.out.println("--------------");

            System.out.println("x: " + Integer.toBinaryString(x));
            System.out.println("x - 1 : " + Integer.toBinaryString(x - 1));
            x &= (x - 1);
            ones++;
        }
        System.out.println("ones : " + ones);

        System.out.println("===========");
        System.out.println(1 & 2039);
        System.out.println(1 & 2038);
    }
}

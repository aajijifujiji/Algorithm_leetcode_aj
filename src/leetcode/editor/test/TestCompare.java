package leetcode.editor.test;

import java.text.DateFormat;
import java.util.*;

public class TestCompare {
    public static void main(String[] args) {
        int[] a = new int[10];
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(a));
        Comparator cmp = new MyComparator();
        Arrays.sort(args, cmp);
        System.out.println(Arrays.toString(a));
    }

    static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }

    }


}

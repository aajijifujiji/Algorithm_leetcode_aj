package leetcode.editor.cn;

//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 571 👎 0

class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        String s = "bbababaaaababbaabbbabbbaaabbbaaababbabaabbaaaaabbaaabbbbaaabaabbaababbbaabaaababbaaabbbbbbaabbbbbaaabbababaaaaabaabbbababbaababaabbaa";
        String p = "bbabba";
        int in = s.indexOf(p);
        System.out.println(in);
        System.out.println("------------");
        int index = solution.strStr(s, p);
        System.out.println(index);
    }
class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) return 0;
            char[] s = haystack.toCharArray();
            char[] p = needle.toCharArray();
            int[] ne = new int[p.length];
            getNext(p, ne);
            int j = -1;
            for (int i = 0; i < s.length; i++) {
                while (j >= 0 && s[i] != p[j + 1]) {
                    j = ne[j];
                }
                if (s[i] == p[j + 1]) {
                    ++j;
                }
                if ((j + 1) == p.length) {
                    return i - p.length + 1;
                }
            }
            return -1;
        }

        //获取next数组
        public void getNext(char[] s, int[] next) {
            int j = -1;
            next[0] = j;
            for (int i = 1; i < s.length; i++) {
                while (j >= 0 && s[j + 1] != s[i]) {
                    j = next[j];//向前回溯
                }
                if (s[i] == s[j + 1])
                    j++;
                next[i] = j;
            }
        }
    }
}
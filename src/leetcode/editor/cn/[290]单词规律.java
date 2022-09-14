package leetcode.editor.cn;

//给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 
//
// 示例1: 
//
// 
//输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 
//输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 
//输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= pattern.length <= 300 
// pattern 只包含小写英文字母 
// 1 <= s.length <= 3000 
// s 只包含小写英文字母和 ' ' 
// s 不包含 任何前导或尾随对空格 
// s 中每个单词都被 单个空格 分隔 
// 
// Related Topics 哈希表 字符串 👍 468 👎 0

import java.util.HashMap;

class WordPattern{
    public static void main(String[] args) {
        Solution solution = new WordPattern().new Solution();
        boolean b = solution.wordPattern("abba", "dog cat cat dog");
        System.out.println(b);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> m = new HashMap<>();
        HashMap<String, Character> p = new HashMap<>();

        int i = 0;
        int h = pattern.length();
        for (int j = 0; j < pattern.length(); j++) {
            char ch = pattern.charAt(j);
            if(i >= h)return false;
            int k = i;
            while(s.charAt(k) != ' '){
                k++;
            }
            String tmp = s.substring(i, k);
            if(m.containsKey(ch) && !m.get(ch).equals(tmp)) return false;
            if(p.containsKey(tmp) && !p.get(tmp).equals(ch)) return false;
            m.put(ch, tmp);
            p.put(tmp, ch);
            i = k + 1;
        }
        return i >= h;

/*
        HashMap<Character, String> m = new HashMap<>();
        HashMap<String, Character> p = new HashMap<>();
        String[] sarr = s.split(" ");
        if(sarr.length != pattern.length())
            return false;

        for (int i = 0; i < sarr.length; i++) {
            final char c = pattern.charAt(i);
            final String curStr = sarr[i];
            if(!m.containsKey(c) || !p.containsKey(curStr)){
                if(!(!m.containsKey(c) && !p.containsKey(curStr)) ){
                    return false;
                }
                m.put(c, curStr);
                p.put(curStr, c);
                continue;
            }
            if(!m.get(c).equals(curStr) || !p.get(curStr).equals(c))
                return false;
        }
        return true;
*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
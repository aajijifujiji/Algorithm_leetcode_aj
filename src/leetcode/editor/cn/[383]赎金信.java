package leetcode.editor.cn;

//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。 
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 计数 👍 350 👎 0

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class RansomNote{
    public static void main(String[] args) throws UnsupportedEncodingException {
        Solution solution = new RansomNote().new Solution();

        boolean b = solution.canConstruct("ab", "aab");
        System.out.println(b);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) throws UnsupportedEncodingException {
        if(magazine == null && ransomNote != null)return false;
        if(magazine == null && ransomNote == null)return true;
        final char[] chars = magazine.toCharArray();
        HashMap<Character, Integer> stringIntegerHashMap = new HashMap<Character, Integer>();
        for (char b : chars){
            if(!stringIntegerHashMap.containsKey(b))
                stringIntegerHashMap.put(b, 1);
            if(stringIntegerHashMap.containsKey(b)){
                Integer i = stringIntegerHashMap.get(b);
                stringIntegerHashMap.put(b, ++i);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(!stringIntegerHashMap.containsKey(ransomNote.charAt(i))){
                return false;
            }
            Integer integer = stringIntegerHashMap.get(ransomNote.charAt(i));
            --integer;
            if(integer == 0)
                stringIntegerHashMap.remove(ransomNote.charAt(i));
            stringIntegerHashMap.put(ransomNote.charAt(i), integer);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
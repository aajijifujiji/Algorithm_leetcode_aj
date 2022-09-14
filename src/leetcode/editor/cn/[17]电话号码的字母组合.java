package leetcode.editor.cn;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 891 👎 0

import java.util.ArrayList;
import java.util.List;

class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new Solution();
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public List<String> letterCombinations(String digits) {
            String[][] nums = {
                    {},
                    {"a", "b", "c"},
                    {"d", "e", "f"},
                    {"g", "h", "i"},
                    {"j", "k", "l"},
                    {"m", "n", "o"},
                    {"p", "q", "r", "s"},
                    {"t", "u", "v"},
                    {"w", "x", "y", "z"}
            };
            String[] digitsArr = digits.split("");
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < nums.length; i++) {
                int num = Integer.parseInt(digitsArr[i]);
                list = getList(list, nums[num - 1]);
            }
            return list;
        }

        private List<String> getList(List<String> list, String[] nums) {
            List<String> l2 = new ArrayList<String>();
            for (int i = 0; i < nums.length; i++) {
                if (list.size() > 0)
                    for (int j = 0; j < list.size(); j++) {
                        l2.add(list.get(j) + nums[i]);
                    }
                else
                    l2.add(nums[i]);
            }
            return l2;
        }
        public static void main(String[] args) {
            List<String> stringList = new Solution().letterCombinations("23");
            System.out.println(stringList);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
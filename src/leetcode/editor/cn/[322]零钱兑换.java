package leetcode.editor.cn;

//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
// Related Topics 广度优先搜索 数组 动态规划 👍 1506 👎 0

import java.beans.IntrospectionException;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

class CoinChange{
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
//        int[] coins = {1,2,5};
//        int amount = 11;
        int[] coins = {2};
        int amount = 3;
        System.out.println(solution.coinChange(coins, amount));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

//  dp数组
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];//里面两种值, 1. 剩下步骤次数; 2. 如果剩下这个数目的硬币不能完成凑零钱, 就为Integer.MAX_VALUE;
        //base case
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int res = Integer.MAX_VALUE;
            for (int coin : coins) {//*
                int r = i - coin;//*
                if(r < 0)continue;//*
                if(dp[r] != Integer.MAX_VALUE && res > dp[r] + 1){
                    res = dp[r] + 1;
                }
            }
            dp[i] = res;
        }
        return dp[amount] == Integer.MAX_VALUE? -1: dp[amount];
    }

//递归解法
//public int coinChange(int[] coins, int amount) {
//    return dp(coins, amount);
//}
//        Map<Integer, Integer> dict = new HashMap<>();
//        public int dp(int[] coins, int amount){
//            if(amount == 0)return 0;
//            if(amount < 0)return -1;
//            if(dict.get(amount) != null)return dict.get(amount);
//            int res = Integer.MAX_VALUE;
//            for (int coin : coins) {
//                int r = dp(coins, amount - coin);
//                if(r < 0)continue;
//                res = Integer.min(res, r + 1);
//            }
//            dict.put(amount, res != Integer.MAX_VALUE? res: -1);
//            return dict.get(amount);
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
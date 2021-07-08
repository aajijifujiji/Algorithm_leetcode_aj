package leetcode.editor.test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class test {
    public static void main(String[] args) {
        test t = new test();
        int[] customers = {0,10,9,6};
        int boardingCost = 6;
        int runningCost = 4;
        int k = t.minOperationsMaxProfit(customers,boardingCost,runningCost);
        System.out.println(k);
    }
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int nextWaitNum = 0;
        Queue<Integer> q = new ArrayDeque<Integer>();
//        nextWaitNum = customers[0] <=4?customers[0] :customers[0] - 4;
        nextWaitNum = customers[0];
        if(nextWaitNum ==0){
        }else if (nextWaitNum <= 4  ){
            q.add(nextWaitNum);
            nextWaitNum = 0;
        }else {
            q.add(4);
            nextWaitNum = nextWaitNum - 4;
        }
        //有多余的人
        for (int rount = 1; nextWaitNum > 0 || rount < customers.length; rount++) {
            //还有下一波的人
            if(rount < customers.length){
                nextWaitNum += customers[rount];
            }
            if (nextWaitNum <= 4 ){
                q.add(nextWaitNum);
                nextWaitNum = 0;
            }else {
                q.add(4);
                nextWaitNum = nextWaitNum - 4;
            }
        }
        int profit = 0;
        int maxProfit = 0;
        int rount = 1;
        int maxProfitRount = -1;
        while (!q.isEmpty()){
            profit = q.poll() * boardingCost - runningCost + profit ;
            if(profit > maxProfit){
                maxProfit = profit;
                maxProfitRount = rount++;
                System.out.println(profit);
            }
        }
        return maxProfitRount ;
    }
}

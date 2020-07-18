package com.kkb.chapter02.day03.Demo10101006;

/**
 * @Description: 今天同学们相约一起爬山游玩，为了更好的进行这场活动，大家准备推举
 * 一个人作为出游的临时队长。为了体现合理公平，大家提出了一个比较有趣的
 * 规则。所有人围成一圈，顺序排号。从第一个人开始报数（从 1 到 3 报数），
 * 凡报到 3 的人退出圈子，剩下的人继续报数，最后留下的当选为队长。
 * 请你通过编写程序，求出一组人中的队长是原来第几位同学。
 * @Author: Du Junnan
 * @Date: Created in 22:50 2020/7/10
 * @Modified by:
 */
public class Demo01 {
    public static void main(String[] args) {
        System.out.println(getLeader(6, 3));
    }

    public static int getLeader(int teamNum, int step) {
        int last = 0;
        //初始化队伍
        int[] team = new int[teamNum];
        for(int i = 0; i < teamNum; i++) {
            team[i] = 1;
        }

        //报数标志初始化
        int head = 0;
        int n = 1;
        do {
            head = (head + step - 1) % teamNum;
            while(team[head] != 1) {
                head = (head + 1) % teamNum;
            }
            team[head] = 0;
            head = (head + 1) % teamNum;;
            n++;
        }while(n < (teamNum-1));

        return head;
    }
}

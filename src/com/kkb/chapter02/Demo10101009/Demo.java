package com.kkb.chapter02.Demo10101009;

import java.util.Scanner;

/**
 * @Description: 五子棋训练任务
 * @Author: Du Junnan
 * @Date: Created in 9:50 2020/7/13
 * @Modified by:
 */
public class Demo {

    public static void main(String[] args) {
        //棋盘
        int[][] checkboard = new int[16][16];
        //胜负
        boolean isWin = false;
        //走黑棋或白棋
        int step = -1;
        //总步数
        int sum = 1;
        //棋子坐标
        int x = -1;
        int y = -1;

        //初始化棋盘
        for(int i = 0; i < checkboard.length; i++) {
            for(int j = 0; j < checkboard[i].length; j++) {
                if(i == 0) {
                    checkboard[0][j] = j;
                } else {
                    checkboard[i][0] = i;
                    checkboard[i][j] = 0;
                }
            }
        }

        //开始游戏
        System.out.println("游戏开始！");
        while(!isWin) {
            //本次是黑或白棋
            step = sum % 2;
            //输入
            Scanner input = new Scanner(System.in);
            //显示棋盘
            printCheckBoard(checkboard);

            //输入横纵坐标
            int chessPoint;
            if(step == 1) {
                System.out.println("请黑方落子：");
                chessPoint = 1;
            } else if(step == 0) {
                System.out.println("请白方落子：");
                chessPoint = 2;
            } else {
                System.out.println("---出错啦---");
                continue;
            }
            System.out.println("棋子的横坐标x = ");
            if(input.hasNextInt()) {
                int temp = input.nextInt();
                if(temp > 15 || temp < 1) {
                    System.out.println("--请重新落子，输入棋盘之内的数字--");
                    continue;
                } else {
                    x = temp;
                }
            } else {
                System.out.println("--请重新落子，输入棋盘之内的数字--");
                continue;
            }
            System.out.println("棋子的纵坐标y = ");
            if(input.hasNextInt()) {
                int temp = input.nextInt();
                if(temp > 15 || temp < 1) {
                    System.out.println("--请重新落子，输入棋盘之内的数字--");
                    continue;
                } else {
                    y = temp;
                }
            } else {
                System.out.println("--请重新落子，输入棋盘之内的数字--");
                continue;
            }

            //判断落子是否重复,不重复则落子
            if(checkboard[x][y] != 0) {
                System.out.println("--您下在了已经有棋子的位置，请重新输入位置--");
                continue;
            } else {
                checkboard[x][y] = chessPoint;
            }

            //判断胜负
            //只有当下棋的总步数超过8的时候，才能分出胜负
            if(sum > 8) {
                isWin = isWinMethod(checkboard, x, y, chessPoint);
                System.out.println("isWin = " + isWin);
            }
            sum++;
        }
        System.out.println("游戏结束！");
        if(step == 1) {
            System.out.println("黑方获胜");
        } else {
            System.out.println("白方获胜");
        }
    }

    public static void printCheckBoard(int[][] checkboard) {
        System.out.println("*******************************************************************");
        for(int i = 0; i < checkboard.length; i++) {
            for(int j = 0; j < checkboard[i].length; j++) {
                System.out.print(checkboard[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("*******************************************************************");
    }

    public static boolean isWinMethod(int[][] checkboard, int x, int y, int chessPoint) {
        //探索的步数
        int xStep = 0;
        int yStep = 0;
        //连子的个数
        int win = 0;
        //判断方向:true是右、下  false是左、上
        boolean direction = true;
        //横1竖2斜3判断
        int way = 1;
        //判断棋盘上是否满足同色五子相连
        while(checkboard[x+xStep][y+yStep] == chessPoint) {
            win++;
            if(win == 5)
                return true;
            //设置本次xStep
            if(way != 1) {
                if(direction)
                    xStep++;
                else
                    xStep--;
            }
            //设置本次yStep
            if(way != 2) {
                if(direction)
                    yStep++;
                else
                    yStep--;
            }

            //step变化后,判断变化后的棋子是否满足下一次循环条件：是否越界,是否是同一色的棋子
            if((x + xStep > 15) || (y + yStep > 15) || (x + xStep < 0) || (y + yStep < 0) || (checkboard[x+xStep][y+yStep] != chessPoint)){
                //判断是否成功
                if(win == 5)
                    break;
                //换行寻找
                if(direction == false) {
                    if(way < 3){
                        //切换到下一个way
                        way++;
                        //重置相连棋子
                        win = 0;
                        //重置step
                        xStep = 0;
                        yStep = 0;
                        //重置方向判断
                        direction = true;
                    } else {
                        //三个方向都寻找结束，退出
                        break;
                    }
                } else {
                    //换向寻找
                    direction = !direction;
                    //重置xStep
                    if(way != 1) {
                        xStep = 0;
                    }
                    //重置yStep
                    if(way != 2) {
                        yStep = 0;
                    }
                    win--;
                }
            }
        }

        if(win == 5)
            return true;

        return false;
    }

}

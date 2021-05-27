package com.ys.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author HuaDong
 * @date 2021/5/26 23:49
 */
public class H_874_模拟行走机器人 {

    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dir_x = {0, 1, 0, -1};
        int[] dir_y = {1, 0, -1, 0};
        int x = 0;
        int y = 0;
        // 0,1,2,3分别代表北、东、南、西方向，初始为正北方；
        int status = 0;
        int max_distance = 0;
        // 判断障碍物：将障碍物的x和y坐标组合成一个字符串用set保存障碍物，查找的时候只要判断当前坐标组成的串是否在set里即可。
        HashSet<String> blockSet = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            blockSet.add(obstacles[i][0] + "," + obstacles[i][1]);
        }
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1) {
                status += 1;
            }
            if (commands[i] == -2) {
                status += 3;
            }
            if (commands[i] > 0) {
                for (int j = 0; j < commands[i]; j++) {
                    int next_x = x + dir_x[status % 4];
                    int next_y = y + dir_y[status % 4];
                    if (blockSet.contains(next_x + "," + next_y)) {
                        break;
                    } else {
                        x = next_x;
                        y = next_y;
                        max_distance = Math.max(max_distance, x * x + y * y);
                    }
                }
            }
        }
        return max_distance;
    }

    public int robotSim2(int[] commands, int[][] obstacles) {
        int[] dirX = new int[]{0, 1, 0, -1};
        int[] dirY = new int[]{1, 0, -1, 0};
        Set<String> obSet = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obSet.add(obstacles[i][0] + "," + obstacles[i][1]);
        }

        int nextX = 0;
        int nextY = 0;
        int status = 0;
        int res = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1) {
                status += 1;
            } else if (commands[i] == -2) {
                status += 3;
            } else {
                int step = commands[i];
                for (int j = 0; j < step; j++) {
                    nextX += dirX[status % 4];
                    nextY += dirY[status % 4];
                    if (obSet.contains(nextX + "," + nextY)) {
                        nextX -= dirX[status % 4];
                        nextY -= dirY[status % 4];
                        break;
                    }
                    res = Math.max(res, nextX * nextX + nextY * nextY);
                }
            }
        }

        return res;
    }

    @Test
    public void demo() {
        this.robotSim2(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}});
    }
}

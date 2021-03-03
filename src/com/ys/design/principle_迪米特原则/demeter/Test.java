package com.ys.design.principle_迪米特原则.demeter;

/**
 * @author HuaDong
 * @date 2021/3/3 21:54
 */
public class Test {
    public static void main(String[] args) {
        Boss boss = new Boss();
        TeamLeader teamLeader = new TeamLeader();
        boss.commandCheckNumber(teamLeader);
    }
}

package com.ys.design.principle_迪米特原则.demeter;

/**
 * @author HuaDong
 * @date 2021/3/3 21:53
 */
public class Boss {
    public void commandCheckNumber(TeamLeader teamLeader) {
        teamLeader.checkNumberOfCourses();
    }
}

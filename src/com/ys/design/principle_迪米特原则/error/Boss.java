package com.ys.design.principle_迪米特原则.error;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HuaDong
 * @date 2021/3/3 21:53
 */
public class Boss {
    public void commandCheckNumber(TeamLeader teamLeader) {
        // 这里模拟数据库查出20个课程
        List<Course> courseList = new ArrayList<Course>();
        for (int i = 0; i < 20; i++) {
            courseList.add(new Course());
        }
        teamLeader.checkNumberOfCourses(courseList);
    }
}

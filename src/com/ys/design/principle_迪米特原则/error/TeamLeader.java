package com.ys.design.principle_迪米特原则.error;

import java.util.List;

/**
 * @author HuaDong
 * @date 2021/3/3 21:53
 */
public class TeamLeader {
    public void checkNumberOfCourses(List<Course> courseList){
        System.out.println("在线课程的数量是：" + courseList.size());
    }
}

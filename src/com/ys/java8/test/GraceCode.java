package com.ys.java8.test;

import com.sun.istack.internal.NotNull;

import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.*;

/**
 * @author HuaDong
 * @since 2020/4/16 20:15
 */
public class GraceCode {
//    public class HttpConnection{
//        private static final long TIMEOUT = 5L;
//    }
//
//    public static Integer isValid() {
//        Integer sum = 0;
//        int[] values = ...;
//        for (int value : values) {
//            sum += value;
//        }
//        return sum;
//    }
//
//    public static int isValid() {
//        int sum = 0;
//        int[] values = ...;
//        for (int value : values) {
//            sum += value;
//        }
//        return sum;
//    }

//    public final class Accumulator {
//        private double result = 0.0D;
//        public void addAll(@NotNull double[] values) {
//            double sum = 0.0D;
//            for (double value : values) {
//                sum += value;
//            }
//            result += sum;
//        }
//    }
//
//    public void demo() {
//        List<UserDO> userDOList = ...;
//        List<UserVO> userVOList = new ArrayList<>(userDOList.size());
//        for (UserDO userDO : userDOList) {
//            userVOList.add(new UserVO(
//                    userDO.getName(),
//                    userDO.getPhone(),
//                    userDO.getIcon()
//            ));
//        }
//    }
//
//    public static int getMonth(Date date) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        return calendar.get(Calendar.MONTH) + 1;
//    }

//    public static boolean isValid(@NotNull UserDO user) {
//        return Boolean.TRUE.equals(user.getIsValid());
//    }

//    public void demo() {
//        List<UserDO> userList = ...;
//        int userLength = userList.size();
//        for (int i = 0; i < userLength; i++) {
//            ...
//        }
//    }

//    public void demo() {
//        List<UserDO> userList = userDAO.queryActive();
//        if (isAll) {
//            userList = userDAO.queryAll();
//        }
//    }
//
//    public void demo() {
//        List<UserDO> userList;
//        if (isAll) {
//            userList = userDAO.queryAll();
//        }else{
//            userList = userDAO.queryActive();
//        }
//    }

//    public void demo() {
//        List<String> typeList = new ArrayList<>(8);
//        typeList.add("Short");
//        typeList.add("Long");
//        typeList.add("Integer");
//        String[] names = ...;
//        List<String> nameList = ...;
//        nameList.addAll(Arrays.asList(names));
//    }

//    public void demo() {
//        Map<Long, UserDO> userMap = ...;
//        for (Map.Entry<Long, UserDO> userEntry : userMap.entrySet()) {
//            Long userId = userEntry.getKey();
//            UserDO user = userEntry.getValue();
//        }
//    }

//    public void demo() {
//        List<UserDO> userList = ...;
//        if (userList.isEmpty()) {
//            ...
//        }
//        Map<Long, UserDO> userMap = ...;
//        if (userMap.isEmpty()) {
//            ...
//        }
//    }

//    public void demo() {
//        LinkedList<UserDO> userDOLinkedList = ...;
//        int size = userDOLinkedList.size();
//        for (UserDO userDO : userDOLinkedList) {
//            ...
//        }
//    }
//
//    public void demo() {
//        Set<Long> adminList = ...;
//        List<UserDO> userDOList = ...;
//        List<UserVO> userVOList = new ArrayList<>(userDOList.size());
//        for (UserDO userDO : userDOList) {
//            if (adminList.contains(userDO.getId())) {
//                userVOList.add(transUser(userDO));
//            }
//        }
//    }

//    public static UserVO transUser(UserDO user, Map<Long, RoleDO> roleMap) {
//        UserVO userVO = new UserVO();
//        userVO.setId(user.getId());
//        if (roleMap.containsKey(user.getRoleId)) {
//            userVO.setRole(transRole(role));
//        }
//    }
//
//    public static UserVO transUser(UserDO user, Map<Long, RoleDO> roleMap) {
//        UserVO userVO = new UserVO();
//        userVO.setId(user.getId());
//        RoleDO role = roleMap.get(user.getRoleId());
//        if (Objects.nonNull(role)) {
//            userVO.setRole(transRole(role));
//        }
//    }

//    public void demo() {
//        try {
//            saveData();
//        } catch (IOException e) {
//            log.error("保存数据IO异常", e);
//        } catch (Exception e) {
//            log.error("保存数据其他异常", e);
//        }
//    }
//
//    public static List<Result> getResultList() {
//        return null;
//    }

//    private static boolean fileReader(String fileName) {
//        // 可能报空异常
//        return fileName.equals("Java开发手册");
//    }
//
//    private static boolean fileReader(String fileName) {
//        return "Java开发手册".equals(fileName);
//    }
}

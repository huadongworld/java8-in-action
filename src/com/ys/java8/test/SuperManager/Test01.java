package com.ys.java8.test.SuperManager;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.regex.Pattern;

public class Test01 {

    @Test
    public void Demo01() {
        System.out.println(SuperManagerIdTab.map.get("2"));
    }

    @Test
    public void Test001() {

        List<String> list = null;
        System.out.println(list == null);
        List<String> list1 = new ArrayList<>();
        System.out.println(list1 == null);
    }

    @Test
    public void Test002() {
        String tableStr = "smids_answer_id#smids_attendance_calendar_id#smids_attendance_config_id#smids_attendance_detail_id#smids_attendance_id#smids_attendance_month_view_id#smids_attendance_work_day_id#smids_check_task_history_id#smids_check_task_id#smids_check_task_participant_detail_history_id#smids_check_task_participant_detail_id#smids_check_task_participant_history_id#smids_check_task_participant_id#smids_check_task_request_id#smids_check_task_user_activity_id#smids_company_id#smids_contact_group_id#smids_customer_asset_id#smids_customer_basic_info_id#smids_customer_contact_id#smids_customer_id#smids_customer_identify_id#smids_customer_order_id#smids_customer_schedule_id#smids_customer_schedule_remark_id#smids_customer_version_id#smids_day_event_attach_id#smids_day_event_comment_at_user_id#smids_day_event_comment_id#smids_day_event_id#smids_day_event_participant_id#smids_day_event_remind_id#smids_day_event_type_counter_id#smids_day_event_type_id#smids_day_event_types_id#smids_deleted_check_task_request_id#smids_deleted_customer_contact_id#smids_department_id#smids_dictionary_id#smids_failed_sms_log_id#smids_feedback_id#smids_follow_event_attach_id#smids_follow_event_id#smids_follow_record_comment_at_user_id#smids_follow_record_comment_id#smids_follow_record_detail_attach_id#smids_follow_record_detail_id#smids_follow_record_id#smids_follow_record_participant_id#smids_follow_record_remind_id#smids_follow_record_types_id#smids_followed_customer_id#smids_group_id#smids_invitation_id#smids_leader_sub_employee_id#smids_login_log_id#smids_manager_id#smids_max_no_id#smids_my_contact_id#smids_my_customer_version_id#smids_pending_approval_user_id#smids_plan_id#smids_question_id#smids_security_level_id#smids_statistic_id#smids_sync_version_id#smids_task_log_id#smids_user_activity_counter_id#smids_user_company_id#smids_user_group_id#smids_user_id#smids_user_log_id#smids_user_relation_id#smids_user_work_day_id#smids_usertarget_id#smids_work_log_comment_at_user_id#smids_work_log_comment_id#smids_work_log_id";
        List<String> tables = Arrays.asList(tableStr.split("#"));
        int flag = 0;
        Test001();
        for (String tab : tables) {
            if (flag++ > 10) {
                break;
            }
            String tabSubAndUpper = tab.substring(6).toUpperCase();
//            System.out.println("String " + tabSubAndUpper + " = \"" + tab + "\";");

            String key = tabSubAndUpper.replaceAll("_", "");
            System.out.println("put(\"" + key + "\", \"" + tab + "\");");

            System.out.println();
        }

        Test001();
    }

    @Test
    public void Test003() {

        /*测试合并两个类型相同的list*/
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();

        //给list1赋值
        list1.add("测");
        list1.add("试");
        list1.add("一");
        list1.add("下");

        //给list2赋值
        list2.add("合");
        list2.add("并");
        list2.add("列");
        list2.add("表");

        //将list1.list2合并
        list1.addAll(list2);

        //循环输出list1 看看结果
        for (String s : list1) {
            System.out.print(s);
        }
    }

    @Test
    public void Test004() {

        Apple apple = new Apple(
                "bigApple",
                100L
        );
        Apple appleNull = new Apple(
                null,
                100L
        );
        Apple nullApple = null;

        if(apple.getName().equals("bigApple")){
            System.out.println("apple找到了");
        }
        if(appleNull.getName().equals("bigApple")){
            System.out.println("appleNull找到了");
        }
        if(nullApple.getName().equals("bigApple")){
            System.out.println("nullApple找到了");
        }

//        if("bigApple".equals(apple.getName())){
//            System.out.println("----------apple找到了");
//        }
//        if("bigApple".equals(appleNull.getName())){
//            System.out.println("----------appleNull找到了");
//        }
//        if("bigApple".equals(nullApple.getName())){
//            System.out.println("----------nullApple找到了");
//        }

    }

    @Test
    public void Test005() {

        List<String> authCodes = Arrays.asList("1", "3", "20", "18");
        String strCodes = getAllCodes(authCodes);
        System.out.println(strCodes);

        List<String> codes = Arrays.asList(strCodes.split(","));
        codes.forEach(System.out::println);
    }

    private String getAllCodes(List<String> codes) {

        String allCodes = StringUtils.join(codes, ",");
        allCodes = allCodes.length() > 0 ? allCodes : "";

        return allCodes;
    }

    @Test
    public void Test006() {

        String str1 = "1231";
        String str2 = "1a231";
        String str3 = "-0.1";
        String str4 = "000";
        String str5 = "000o";
        String str6 = "-1231";

        System.out.println(isInteger(str1));
        System.out.println(isInteger(str2));
        System.out.println(isInteger(str3));
        System.out.println(isInteger(str4));
        System.out.println(isInteger(str5));
        System.out.println(isInteger(str6));
    }

    private static final Pattern IS_INTEGER = Pattern.compile("^[-\\+]?[\\d]*$");
    public static boolean isInteger(String str) {
        return IS_INTEGER.matcher(str).matches();
    }

    @Test
    public void Test007() {



    }

    @Test
    public void testThreadLocal() {
        Thread t = new Thread() {
            ThreadLocal<String> mStringThreadLocal = new ThreadLocal<String>(){
                @Override
                protected String initialValue() {
                    return Thread.currentThread().getName();
                }
            };

            @Override
            public void run() {
                super.run();
                System.out.println(mStringThreadLocal.get());
                mStringThreadLocal.set("droidyue.com");
                mStringThreadLocal.set("adsffasdf");
                mStringThreadLocal.get();
                System.out.println(mStringThreadLocal.get());
            }
        };

        t.start();
    }

    @Test
    public void testInheritableThreadLocal() {

        final ThreadLocal threadLocal = new InheritableThreadLocal();

        threadLocal.set("droidyue.com");
        Thread t = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println(threadLocal.get());
            }
        };

        t.start();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println(threadLocal.get());
            }
        };

        t1.start();
    }

    @Test
    public void Test010() {

        List<Integer> customerIds = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 6);

        List<Integer> superCustomerIds = Arrays.asList(3, 4, 5, 6, 7, 8, 8, 8, 8);

        Set<Integer> customerIdSet = new HashSet<Integer>(customerIds);

        Set<Integer> superCustomerIdSet = new HashSet<Integer>(superCustomerIds);

        superCustomerIdSet.removeAll(customerIdSet);

        List<Integer> newList = new ArrayList<>(superCustomerIdSet);

        System.out.println(newList);
    }
}

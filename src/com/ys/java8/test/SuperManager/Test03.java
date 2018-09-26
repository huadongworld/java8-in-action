package com.ys.java8.test.SuperManager;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class Test03 {

    private final static String MANAGE_TYPE_ONE = "快修快保";
    private final static String MANAGE_TYPE_TWO = "机修";
    private final static String MANAGE_TYPE_THREE = "美容";
    private final static String MANAGE_TYPE_FOUR = "改装";
    private final static String MANAGE_TYPE_FIVE = "豪车专修";
    private final static String MANAGE_TYPE_SIX = "其他";

    private final static String MANAGE_SCALE_ONE = "单店";
    private final static String MANAGE_SCALE_TWO = "1-2家连锁店";
    private final static String MANAGE_SCALE_THREE = "3家连锁店及以上";

    private final static String MANAGE_ACREAGE_ONE = "0到3";
    private final static String MANAGE_ACREAGE_TWO = "4到9";
    private final static String MANAGE_ACREAGE_THREE = "10以上";

    private static Map<String, Map<String, Map<String, String>>> manageTypeMap = new HashMap<>(7);
    private static Map<String, Map<String, String>> manageScaleMap = new HashMap<>(4);
    private static Map<String, String> manageAcreageMap = new HashMap<>(4);

    static  {
        manageAcreageMap.put(MANAGE_ACREAGE_ONE, "C");
        manageAcreageMap.put(MANAGE_ACREAGE_TWO, "C");
        manageAcreageMap.put(MANAGE_ACREAGE_THREE, "B");
        manageScaleMap.put(MANAGE_SCALE_ONE, manageAcreageMap);
        manageAcreageMap.put(MANAGE_ACREAGE_ONE, "C");
        manageAcreageMap.put(MANAGE_ACREAGE_TWO, "B");
        manageAcreageMap.put(MANAGE_ACREAGE_THREE, "A");
        manageScaleMap.put(MANAGE_SCALE_TWO, manageAcreageMap);
        manageAcreageMap.put(MANAGE_ACREAGE_ONE, "B");
        manageAcreageMap.put(MANAGE_ACREAGE_TWO, "A");
        manageAcreageMap.put(MANAGE_ACREAGE_THREE, "A");
        manageScaleMap.put(MANAGE_SCALE_THREE, manageAcreageMap);
        manageTypeMap.put(MANAGE_TYPE_ONE, manageScaleMap);

        manageAcreageMap.put(MANAGE_ACREAGE_ONE, "C");
        manageAcreageMap.put(MANAGE_ACREAGE_TWO, "B");
        manageAcreageMap.put(MANAGE_ACREAGE_THREE, "A");
        manageScaleMap.put(MANAGE_SCALE_ONE, manageAcreageMap);
        manageAcreageMap.put(MANAGE_ACREAGE_ONE, "B");
        manageAcreageMap.put(MANAGE_ACREAGE_TWO, "B");
        manageAcreageMap.put(MANAGE_ACREAGE_THREE, "A");
        manageScaleMap.put(MANAGE_SCALE_TWO, manageAcreageMap);
        manageAcreageMap.put(MANAGE_ACREAGE_ONE, "A");
        manageAcreageMap.put(MANAGE_ACREAGE_TWO, "A");
        manageAcreageMap.put(MANAGE_ACREAGE_THREE, "A");
        manageScaleMap.put(MANAGE_SCALE_THREE, manageAcreageMap);
        manageTypeMap.put(MANAGE_TYPE_TWO, manageScaleMap);

        manageAcreageMap.put(MANAGE_ACREAGE_ONE, "C");
        manageAcreageMap.put(MANAGE_ACREAGE_TWO, "C");
        manageAcreageMap.put(MANAGE_ACREAGE_THREE, "B");
        manageScaleMap.put(MANAGE_SCALE_ONE, manageAcreageMap);
        manageAcreageMap.put(MANAGE_ACREAGE_ONE, "C");
        manageAcreageMap.put(MANAGE_ACREAGE_TWO, "C");
        manageAcreageMap.put(MANAGE_ACREAGE_THREE, "B");
        manageScaleMap.put(MANAGE_SCALE_TWO, manageAcreageMap);
        manageAcreageMap.put(MANAGE_ACREAGE_ONE, "B");
        manageAcreageMap.put(MANAGE_ACREAGE_TWO, "B");
        manageAcreageMap.put(MANAGE_ACREAGE_THREE, "A");
        manageScaleMap.put(MANAGE_SCALE_THREE, manageAcreageMap);
        manageTypeMap.put(MANAGE_TYPE_THREE, manageScaleMap);

        manageAcreageMap.put(MANAGE_ACREAGE_ONE, "C");
        manageAcreageMap.put(MANAGE_ACREAGE_TWO, "C");
        manageAcreageMap.put(MANAGE_ACREAGE_THREE, "B");
        manageScaleMap.put(MANAGE_SCALE_ONE, manageAcreageMap);
        manageAcreageMap.put(MANAGE_ACREAGE_ONE, "C");
        manageAcreageMap.put(MANAGE_ACREAGE_TWO, "C");
        manageAcreageMap.put(MANAGE_ACREAGE_THREE, "B");
        manageScaleMap.put(MANAGE_SCALE_TWO, manageAcreageMap);
        manageAcreageMap.put(MANAGE_ACREAGE_ONE, "B");
        manageAcreageMap.put(MANAGE_ACREAGE_TWO, "B");
        manageAcreageMap.put(MANAGE_ACREAGE_THREE, "A");
        manageScaleMap.put(MANAGE_SCALE_THREE, manageAcreageMap);
        manageTypeMap.put(MANAGE_TYPE_FOUR, manageScaleMap);

        manageAcreageMap.put(MANAGE_ACREAGE_ONE, "C");
        manageAcreageMap.put(MANAGE_ACREAGE_TWO, "A");
        manageAcreageMap.put(MANAGE_ACREAGE_THREE, "A");
        manageScaleMap.put(MANAGE_SCALE_ONE, manageAcreageMap);
        manageAcreageMap.put(MANAGE_ACREAGE_ONE, "B");
        manageAcreageMap.put(MANAGE_ACREAGE_TWO, "A");
        manageAcreageMap.put(MANAGE_ACREAGE_THREE, "A");
        manageScaleMap.put(MANAGE_SCALE_TWO, manageAcreageMap);
        manageAcreageMap.put(MANAGE_ACREAGE_ONE, "A");
        manageAcreageMap.put(MANAGE_ACREAGE_TWO, "A");
        manageAcreageMap.put(MANAGE_ACREAGE_THREE, "A");
        manageScaleMap.put(MANAGE_SCALE_THREE, manageAcreageMap);
        manageTypeMap.put(MANAGE_TYPE_FIVE, manageScaleMap);

        manageAcreageMap.put(MANAGE_ACREAGE_ONE, "C");
        manageAcreageMap.put(MANAGE_ACREAGE_TWO, "C");
        manageAcreageMap.put(MANAGE_ACREAGE_THREE, "B");
        manageScaleMap.put(MANAGE_SCALE_ONE, manageAcreageMap);
        manageAcreageMap.put(MANAGE_ACREAGE_ONE, "C");
        manageAcreageMap.put(MANAGE_ACREAGE_TWO, "C");
        manageAcreageMap.put(MANAGE_ACREAGE_THREE, "B");
        manageScaleMap.put(MANAGE_SCALE_TWO, manageAcreageMap);
        manageAcreageMap.put(MANAGE_ACREAGE_ONE, "B");
        manageAcreageMap.put(MANAGE_ACREAGE_TWO, "B");
        manageAcreageMap.put(MANAGE_ACREAGE_THREE, "A");
        manageScaleMap.put(MANAGE_SCALE_THREE, manageAcreageMap);
        manageTypeMap.put(MANAGE_TYPE_SIX, manageScaleMap);
    }

    private static int i = 10;

    @Test
    public void demo02() {
        List<Long> all = new ArrayList<>();
        List<Long> as = all
                .stream()
                .filter(a -> a.toString().equals(""))
                .collect(toList());
        System.out.println(as);
    }
}

package com.heima.common.schedule;

public class ScheduleConstants {
    //task状态
    public static final int SCHEDULED=0;   //初始化状态

    public static final int EXECUTED=1;       //已执行状态

    public static final int CANCELLED=2;   //已取消状态

    public static String FUTURE="future";   //未来数据key前缀

    public static String TOPIC="topic";     //当前数据key前缀

}

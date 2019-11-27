package com.shop.common.utils;

import java.text.SimpleDateFormat;

/**
 * 常量
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月15日 下午1:23:52
 */
public class Constant {
    /**
     * 超级管理员ID
     */
    public static final int SUPER_ADMIN = 1;

    /**
     * 菜单类型
     *
     * @author chenshun
     * @email sunlightcs@gmail.com
     * @date 2016年11月15日 下午1:24:29
     */
    public enum MenuType {
        /**
         * 目录
         */
        CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 定时任务状态
     *
     * @author chenshun
     * @email sunlightcs@gmail.com
     * @date 2016年12月3日 上午12:07:22
     */
    public enum ScheduleStatus {
        /**
         * 正常
         */
        NORMAL(0),
        /**
         * 暂停
         */
        PAUSE(1);

        private int value;

        ScheduleStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 云服务商
     */
    public enum CloudService {
        /**
         * 七牛云
         */
        QINIU(1),
        /**
         * 阿里云
         */
        ALIYUN(2),
        /**
         * 腾讯云
         */
        QCLOUD(3);

        private int value;

        CloudService(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }


    }

    /**
     * 项目状态
     */
    public enum ProConfStatus {

        CONFIGING("01", "配置中"),

        FINISHCONFIG("02", "配置完成"),

        PUTAWAY("03", "上架"),

        SOLDOUT("04", "下架");

        private String code;

        private String name;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private ProConfStatus(String code, String name) {
            this.name = name;
            this.code = code;
        }
    }

    /**
     * 清单校验状态
     */
    public enum LocalCheckResults {

        WAITCHECK("04", "待校验"),

        CHECKSUCCESS("01", "成功"),

        CHECKFAILURE("02", "失败"),

        CHECKING("03", "校验中"),;
        private String code;

        private String name;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private LocalCheckResults(String code, String name) {
            this.name = name;
            this.code = code;
        }
    }

    /**
     * 字段类型
     */
    public enum ColumnType {

        DATE("20", "日期"),

        TIME("21","时间"),

        NUMBER("07", "数字"),

        TEXT("00", "文本"),;
        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private ColumnType(String code, String name) {
            this.name = name;
            this.code = code;
        }
    }

    /**
     * 案件节点
     */
    public enum CaseNode {

        UPLOAD("01", "案件上载"),
        VERIFY("02", "案件校验"),
        FIRSTUW("03", "一级审核"),
        SECONDUW("04", "二级审核"),;

        private String code;

        private String name;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private CaseNode(String code, String name) {
            this.name = name;
            this.code = code;
        }
    }

    /**
     * 清单校验状态
     */
    public enum ThirdClaimStatus {

        WAIT("01", "待处理"),

        PASS("02", "通过"),

        UNPASS("03", "不通过"),

        ;
        private String code;

        private String name;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private ThirdClaimStatus(String code, String name) {
            this.name = name;
            this.code = code;
        }
    }

    /**
     * 字段类型：数字
     */
    public static final String COLUMN_TYPE_NUMBER = "07";

    /**
     * 字段类型：日期
     */
    public static final String COLUMN_TYPE_DATE = "20";

    /**
     * 字段类型：时间
     */
    public static final  String COLUMN_TYPE_TIME = "21";

    /**
     * 字段类型：文本
     */
    public static final String COLUMN_TYPE_TEXT = "00";

    /**
     * 有效标识
     */
    public static final String VALID_IND = "1";

    /**
     * 无效标识
     */
    public static final String UN_VALID_IND = "0";

    /**
     * 操作状态:正常
     */
    public static final String NORMAL_STATUS = "1";

    /**
     * 操作状态:删除
     */
    public static final String DELETE_STATUS = "0";

    /**
     * 审核模式:一级
     */
    public static final String VERIVY_MODEL_FIRST = "1";

    /**
     * 审核模式:二级
     */
    public static final String VERIVY_MODEL_SECOND = "2";

    /**
     * 选择类型:是
     */
    public static final String YES = "1";

    /**
     * 选择类型:否
     */
    public static final String NO = "0";

    /**
     * 报案主表节点名
     */
    public static final String REPORT_MAIN_NODE_NAME = "reportMain";

    /**
     * 报案扩展表节点名
     */
    public static final String REPORT_EXT_NODE_NAME = "reportExt";

    /**
     * 文件请求的接口类型代码
     */
    public static final String FILE_REQUEST_TYPE = "0300014";

    /**
     * 保单已决赔款请求的接口类型代码
     */
    public static final String SUM_PAID_REQUEST_TYPE = "0300020";

    /**
     * 保单信息请求的接口类型代码
     */
    public static final String POLICY_REQUEST_TYPE = "0300024";

    /**
     * 案件节点请求的接口类型代码
     */
    public static final String CASE_STATUS_REQUEST_TYPE = "020001";

    /**
     * 小微送三代理赔接口类型代码
     */
    public static final String MICRO_CLAIM_REQUEST_TYPE = "01050088";

    /**
     * 文件类 3--文本
     */
    public static final String FILE_TYPE = "3";

    /**
     * 成功代码
     */
    public static final String SUCCESS_CODE = "000000";

    /**
     * 日期转换定义格式：yyyyMMddhhmmss
     */
    public static final SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMddhhmmss");

    /**
     * 接口成功标识
     */
    public static final String SUCCESS = "Y";

    /**
     * 案件状态接口成功标识
     */
    public static final String CASE_SUCCESS_CODE = "200";


    /**
     * 审核通过
     */
    public static final String UW_RESULT_Y = "01";

    /**
     * 审核不通过
     */
    public static final String UW_RESULT_N = "02";

    /**
     * 系统自动
     */
    public static final Long SYSTEM_USER_AUTO = 0L;

    /**
     * 项目每日赔付金额
     */
    public static final String PROJECT_DAILY_LOSS = "projectDailyLoss";

    /**
     * 当前批次赔付总额
     */
    public static final String BATCH_SUM_LOSS = "batchSumLoss";

    /**
     * 系统管理员名称
     */
    public static final String SYSTEM_ROLE_NAME ="系统管理员";
}

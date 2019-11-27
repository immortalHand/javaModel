package com.shop.common.utils;


import java.util.Date;
import java.util.List;

import static com.shop.common.utils.ShiroUtils.getUserId;


/**
 * <li>Title: ToolsUtils.java</li> <li>Project: account</li> <li>Package: com.sinosoft.account.util</li> <li>
 * Description:</li> <li>Copyright: Copyright (c) 2008</li> <li>Company: sinosoft</li> <li>Created on Mar 13, 2009
 * 8:15:37 PM</li>
 * 
 * @author lisitao
 * @version 1.0
 */

public class ToolsUtils {
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(List list) {
        if (list == null || list.size() < 1) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(String[] items) {
        if (items == null || items.length < 1) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Object obj){
        if(obj != null){
            return false;
        }
        return true;
    }

    public static boolean notEmpty(String str) {
        if (str != null && !"".equals(str.trim())) {
            return true;
        }
        return false;
    }

    public static boolean notEmpty(List list) {
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    public static boolean notEmpty(String[] items) {
        if (items != null && items.length > 0) {
            return true;
        }
        return false;
    }

    public static boolean notEmpty(Object obj){
        if(obj != null){
            return true;
        }
        return false;
    }

    /**
      * @Title ToolsUtils
      * @Description 验证是否不包含指定字符串
      * @author xruichang
      * @date 2018年07月06日 13:58
      * @version V1.0
      * @param str 传过来的值
      * @param item 限制输入内容，多个数据的时候请用","分隔开
      * @return boolean 相等返回flase
      * @since V1.0
      */
    public static boolean notContains(final String str, final String item) {
        final String[] itemList = item.split(",");
        for (final String items : itemList) {
            if (items.equals(str)) {
                return false;
            }
        }
        return true;
    }

    /**
      * @Title ToolsUtils
      * @Description 验证是否包含指定字符串
      * @author xruichang
      * @date 2018年07月06日 13:58
      * @version V1.0
      * @param str 传过来的值
      * @param item 限制输入内容，多个数据的时候请用","分隔开
      * @return boolean 相等返回true
      * @since V1.0
      */
    public static boolean contains(final String str, final String item) {
        final String[] itemList = item.split(",");
        for (final String items : itemList) {
            if (items.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static void setUserAndDate(Object object) throws Exception {
        String userId = String.valueOf(getUserId());
        Date date = new Date();
        Class cls = object.getClass();
        cls.getMethod("setCreatedUser",String.class).invoke(object,userId);
        cls.getMethod("setCreatedDate",Date.class).invoke(object,date);
        cls.getMethod("setUpdatedUser",String.class).invoke(object,userId);
        cls.getMethod("setUpdatedDate",Date.class).invoke(object,date);
    }

    public static void setUpdateUserAndDate(Object object) throws Exception {
        String userId = String.valueOf(getUserId());
        Date date = new Date();
        Class cls = object.getClass();
        cls.getMethod("setUpdatedUser",String.class).invoke(object,userId);
        cls.getMethod("setUpdatedDate",Date.class).invoke(object,date);
    }
}

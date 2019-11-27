package com.shop.modules.sys.service;

/**
 * @Desc excel服务类
 * @Author sinosoft-an
 * @Date 2019/2/24 16:44
 */
public interface SysExcelService {

    /**
     * @Desc 根据对象生成excel
     * @param  object 对象
     * @Author sinosoft-an
     * @Date 2019/2/24 16:45
     */
    public void createExcel(Object object)throws Exception;

}
